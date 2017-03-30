package com.example.activitylifecycletest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"Boot complete",Toast.LENGTH_SHORT).show();
       Intent StartIntent=new Intent(context,MainActivity.class);
        StartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(StartIntent);
    }
}
