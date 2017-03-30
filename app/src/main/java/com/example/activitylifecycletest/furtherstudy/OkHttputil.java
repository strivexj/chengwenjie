package com.example.activitylifecycletest.furtherstudy;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 10032 on 2017/2/6.
 */

public class OkHttputil {
    private static String parseXMLWithPull(String xmlData){
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
        return translate.toString();
    }
    private static void sendRequestWithOkHttp(final String ourl){
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

}
