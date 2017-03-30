package com.example.activitylifecycletest;

import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
    private WebView webview;
    private boolean isExit;
    private EditText address;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //实例化WebView对象
        webview =(WebView)findViewById(R.id.webView);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        //设置WebView属性，能够执行Javascript脚本
        webview.getSettings().setJavaScriptEnabled(true);
        //设置 缓存模式webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT); // 开启 DOM storage API 功能
        webview.getSettings().setDomStorageEnabled(true);
        WebSettings ws=webview.getSettings();
        ws.setBuiltInZoomControls(true);
        ws.setJavaScriptEnabled(true);
        //加载需要显示的网页
        webview.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url) {
                address.setText(webview.getUrl());
            }

        });


            webview.loadUrl("https://www.sogou.com/");

        Button search=(Button)findViewById(R.id.search);
        address=(EditText)findViewById(R.id.adress) ;
        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String sadress="http://"+address.getText().toString();
                webview.loadUrl(sadress);
            }
        });


    }

    /*public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            // goBack()表示返回WebView的上一页面
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
   /* public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) || webview.canGoBack()) {
            webview.goBack();
            if (!webview.canGoBack()) {
                if (isExit) {
                    return super.onKeyDown(keyCode, event);
                }
                isExit = true;
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            } else {
                isExit = false;
            }
        }
        return true;
    }*/
    private long clickTime=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK|| webview.canGoBack()) {
            webview.goBack();
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if ((System.currentTimeMillis() - clickTime) > 3000) {
            Toast.makeText(getApplicationContext(), "再次点击退出",  Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
            //Log.e(WebViewActivity.this, "exit application");
            this.finish();
            System.exit(0);
        }
    }
}
