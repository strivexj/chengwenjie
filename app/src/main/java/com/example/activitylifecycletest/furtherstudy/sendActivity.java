package com.example.activitylifecycletest.furtherstudy;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activitylifecycletest.R;
import com.example.activitylifecycletest.Tts;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.attr.onClick;


public class sendActivity extends AppCompatActivity{
    private Tts tts;
   private IntentFilter sendFilter;
    private  SendStatusReceiver sendStatusReceiver;
private TextView translate;
    private EditText to;
    private EditText message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        if (ContextCompat.checkSelfPermission(sendActivity.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED) {
            //请求权限
            ActivityCompat.requestPermissions(sendActivity.this,
                    new String[]{Manifest.permission.SEND_SMS},1);
        }


        Button notificaiton=(Button)findViewById(R.id.notification);
        notificaiton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(sendActivity.this,DelayedMessageService.class);
                intent.putExtra("message","啊啊啊啊");
                Log.d("aaaSendActivity","Thread id is "+Thread.currentThread().getId());
                startService(intent);

            }
        });
        final Button startservice=(Button)findViewById(R.id.start_service);
        Button stopservice=(Button)findViewById(R.id.stop_service);
        startservice.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("MyActivity Thread id is",""+Thread.currentThread().getId());
                Intent startIntent=new Intent(sendActivity.this,MyService.class);
                startService(startIntent);
            }
        });
        stopservice.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent stopIntent=new Intent(sendActivity.this,MyService.class);
                stopService(stopIntent);
            }
        });



        Button tab=(Button)findViewById(R.id.tab);
       tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(sendActivity.this,TabsActivity.class);
                startActivity(intent);

            }
        });

         to=(EditText)findViewById(R.id.to);
        to.setText("13927790305");

         message=(EditText)findViewById(R.id.message); message.setText("小天使生日快乐呀呀呀呀");
        Button send=(Button) findViewById(R.id.send);

        sendFilter=new IntentFilter();
        sendFilter.addAction("SENT_SMS_ACTION");
        sendStatusReceiver=new SendStatusReceiver();
        registerReceiver(sendStatusReceiver,sendFilter);




        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int i = 0; i < 7; i++) {
                    if (to.getText().toString().length() == 11) {
                        SmsManager smsManager = SmsManager.getDefault();
                        Intent sentIntent = new Intent("SENT_SMS_ACTION");
                        PendingIntent pi = PendingIntent.getBroadcast
                                (sendActivity.this, 0, sentIntent, 0);
                        //Random=new Random()

                        smsManager.sendTextMessage(to.getText().toString(), null,
                                message.getText().toString(), pi, null);
                    } else {
                        tts = new Tts();
                        tts.speak(sendActivity.this, "Please input a correct phone number");
                        //Toast.makeText(sendActivity.this,"请输入正确的电话号码.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        final EditText original=(EditText)findViewById(R.id.original) ;
        translate=(TextView)findViewById(R.id.translate);
        Button confirm=(Button)findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp("http://fanyi.youdao.com/openapi.do?keyfrom=strive123&key=181998645&type=data&doctype=xml&version=1.1&q="+original.getText().toString());
            }
        });



    }

    private void sendRequestWithHttpURLConnection(final String ourl) {
        new Thread(new Runnable(){
            @Override
            public void run(){
                HttpURLConnection connection=null;
                BufferedReader reader=null;
                try{
                    URL url=new URL(ourl);
                    connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(8000);
                    InputStream in=connection.getInputStream();
                    reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder response=new StringBuilder();
                    String line;
                    //response.append(url);
                    while((line=reader.readLine())!=null)
                    {
                        response.append(line);
                    }
                    showResponse(response.toString());
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if(reader!=null){
                        try{
                            reader.close();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if(connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }


private  void showResponse(final String response){
    runOnUiThread(new Runnable(){
        public void run(){
            translate.setText(response);
        }

    });

}
//用OkHttp

    private void sendRequestWithOkHttp(final String ourl){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder()
                            .url(ourl)
                            .build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    parseXMLWithPull(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void parseXMLWithPull(String xmlData){
        StringBuilder translate=new StringBuilder();;
        try{
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser=factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType=xmlPullParser.getEventType();
            while(eventType!=XmlPullParser.END_DOCUMENT){
                String nodeName=xmlPullParser.getName();

                        if("paragraph".equals(nodeName)||"phonetic".equals(nodeName)||"ex".equals(nodeName)){
                            translate.append(xmlPullParser.nextText());
                            translate.append("\n");
                        }

                eventType=xmlPullParser.next();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       showResponse( translate.toString());
    }
    protected void onDestroy() {
        super.onDestroy();

        //unregisterReceiver(messageReceiver);
        unregisterReceiver(sendStatusReceiver);
      // tts.close();
    }

    class SendStatusReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (getResultCode() == RESULT_OK) {
//  短信发送成功
                Toast.makeText(context, "Send succeeded",
                        Toast.LENGTH_LONG).show();
            } else {
//  短信发送失败
                Toast.makeText(context, "Send failed",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
