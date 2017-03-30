package com.example.activitylifecycletest.furtherstudy;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.activitylifecycletest.R;

import java.lang.reflect.Field;

public class DelayedMessageService extends IntentService {
    private  MediaPlayer mediaPlayer;
   public static final String EXTRA_MESSAGE="message";
    public static final int NOTIFICATION_ID=2148;
    public DelayedMessageService(){
        super("DelayedMessageService");
    }
    protected void onHandleIntent(Intent intent){
        Log.d("aaawawo","Thread id is"+Thread.currentThread().getId());
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music);
        mediaPlayer.start();
       synchronized (this){
           /*  try{
                wait(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();}*/
           String text=intent.getStringExtra(EXTRA_MESSAGE);
           showtext(text);
            }


    }
    public void showtext(String text){
        Intent intent=new Intent(this,sendActivity.class);
        TaskStackBuilder taskStackBuilder=TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(sendActivity.class);
        taskStackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent=taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);


        Notification notification=new Notification();
      try {
            Class miuiNotificationClass = Class.forName("android.app.MiuiNotification");
            Object miuiNotification = miuiNotificationClass.newInstance();
            Field field = miuiNotification.getClass().getDeclaredField("customizedIcon");
            field.setAccessible(true);
            field.set(miuiNotification, true);
            field = notification.getClass().getField("extraNotification");
            field.setAccessible(true);
            field.set(notification, miuiNotification);
          notification=new Notification.Builder(this)
                  .setSmallIcon(R.mipmap.ic_launcher)
                  .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                  .setContentTitle("NotificationManager notificationManager=(NotificationManager)getSys")
                  .setAutoCancel(false)
                  //.setWhen(System.currentTimeMillis())
                  .setPriority(Notification.PRIORITY_MAX)
                  // .setDefaults(Notification.DEFAULT_VIBRATE)
                  .setContentIntent(pendingIntent)
                  .setContentText(text)
                  .build();
        } catch (Exception e) { }
        notification.flags |=Notification.FLAG_NO_CLEAR;
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID,notification);

     /*   try {
            Class miuiNotificationClass = Class.forName("android.app.MiuiNotification");
            Object miuiNotification = miuiNotificationClass.newInstance();
            Field field = miuiNotification.getClass().getDeclaredField("customizedIcon");
            field.setAccessible(true);
            field.set(miuiNotification, true);
            field = notification.getClass().getField("extraNotification");
            field.setAccessible(true);
            field.set(notification, miuiNotification);
        } catch (Exception e) {
        }*/


    }
    public void onDestroy(){
        super.onDestroy();
        mediaPlayer.release();
        Log.d("aaawaco","onDestroy executed");
    }

}
