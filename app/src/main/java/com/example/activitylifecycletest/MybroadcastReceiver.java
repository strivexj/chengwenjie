package com.example.activitylifecycletest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MybroadcastReceiver extends BroadcastReceiver {
    public MybroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"received in MyBroadcastReveiver",Toast.LENGTH_SHORT).show();

    }
}
