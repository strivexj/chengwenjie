package com.example.activitylifecycletest.furtherstudy;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.activitylifecycletest.R;

public class TabsActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        TabHost tabHost=getTabHost();
        TabHost.TabSpec tab1=tabHost.newTabSpec("tab1")
                .setIndicator("已接电话")
                .setContent(R.id.tab1);
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2=tabHost.newTabSpec("tab2")
                .setIndicator("呼出电话")
                .setContent(R.id.tab2);
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3=tabHost.newTabSpec("tab3")
                .setIndicator("未接电话")
                .setContent(R.id.tab3);
        tabHost.addTab(tab3);


    }
}
