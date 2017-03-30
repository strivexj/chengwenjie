package com.example.activitylifecycletest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.activitylifecycletest.furtherstudy.sendActivity;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity  {

    private IntentFilter intentFilter;
    private  NetworkChangeReceiver networkChangeReceiver;
    private Tts tts;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.a: {
                Toast.makeText(MainActivity.this, "you click a", Toast.LENGTH_SHORT).show();
               break;
            }
            case R.id.b:{
                Toast.makeText(this,"You clicked Other",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,OtherActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.c: {
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Exit");
                dialog.setMessage("Are you sure to exit this app?");
                dialog.setCancelable(false);
                dialog.setIcon(R.drawable.b);
                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which)
                    {
                        ActvitiyCollector.finishAll();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
            }
        }
        return true;
    }

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActvitiyCollector.addActivity(this);
        /*ActionBar actionBar=getSupportActionBar();
        actionBar.hide();*/
        setContentView(R.layout.activitylayout);
   //登录成功
        Intent intent=getIntent();
        if(intent.getStringExtra("logged").equals("succeed"))
        {
            tts=new Tts();
            //tts.speak(MainActivity.this,"Logged in sucessfully");
        }

        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);




        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);
        Button button5 = (Button) findViewById(R.id.button_5);
        Button button6 = (Button) findViewById(R.id.button_6);
        Button button7 = (Button) findViewById(R.id.button_7);
        Button button8 = (Button) findViewById(R.id.button_8);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
               // Toast.makeText(MainActivity.this,"you clicked me~!",Toast.LENGTH_SHORT).show();

            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this,"you clicked me~!",Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this,"you clicked me~!",Toast.LENGTH_SHORT).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CameraActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this,"you clicked me~!",Toast.LENGTH_SHORT).show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this,"you clicked me~!",Toast.LENGTH_SHORT).show();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               //设置闹钟
              /* Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM)
                       .putExtra(AlarmClock.EXTRA_MESSAGE,"hhhhh")
                       .putExtra(AlarmClock.EXTRA_HOUR,3)
                       .putExtra(AlarmClock.EXTRA_SKIP_UI,true)
                       .putExtra(AlarmClock.EXTRA_MINUTES,30);
               startActivity(intent);*/
              // Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
             //  startActivityForResult(intent,0);
                Intent intent2 = new Intent(MainActivity.this,LoationActivity.class);
              startActivity(intent2);
                //Toast.makeText(MainActivity.this,"you clicked me~!",Toast.LENGTH_SHORT).show();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
                sendBroadcast(intent);
                //Toast.makeText(MainActivity.this,"you clicked me~!",Toast.LENGTH_SHORT).show();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //建立Intent对象

             //   Intent intent = new Intent();

//设置对象动作

              //  intent.setAction(Intent.ACTION_SEND);

//设置对方邮件地址

            //    intent.putExtra(Intent.EXTRA_EMAIL, new String[]

                     //   { "1003214597@qq.com","565725580@qq.com" });

//设置标题内容

              //  intent.putExtra(Intent.EXTRA_SUBJECT, "test");

//设置邮件文本内容

               // intent.putExtra(Intent.EXTRA_TEXT, "test mail");

//启动一个新的ACTIVITY,"Sending mail..."是在启动这个ACTIVITY的等待时间时所显示的文字

                //startActivity(Intent.createChooser(intent, "Sending mail..."));
                Intent intent=new Intent(MainActivity.this,sendActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }
    protected void onResume(){
        super.onStart();
        Log.d(TAG,"onResume");
    }
    protected void onRestart(){
        super.onStart();
        Log.d(TAG,"onRestart");
    }
    protected void onPause(){
        super.onStart();
        Log.d(TAG,"onPause");
    }
    protected void onStop(){
        super.onStart();
        Log.d(TAG,"onStop");
    }
    protected void onDestroy(){
        super.onDestroy();
        ActvitiyCollector.removeActivity(this);
        unregisterReceiver(networkChangeReceiver);
        //tts.close();
    }
    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            ConnectivityManager connectivityManager=(ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null&&networkInfo.isAvailable()){
               // Toast.makeText(context,"Network is available",Toast.LENGTH_SHORT).show();
            }
            else {
                //Toast.makeText(context,"Network is unavailable",Toast.LENGTH_SHORT).show();
            }

        }
    }
}

