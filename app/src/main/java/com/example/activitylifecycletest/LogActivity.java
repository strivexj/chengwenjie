package com.example.activitylifecycletest;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {
    private  EditText accout;
    private  Button login;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ActvitiyCollector.addActivity(this);

        accout=(EditText)findViewById(R.id.accout);
        password=(EditText)findViewById(R.id.password);

        String defaultaccout="cwj";
        accout.setText(defaultaccout);
        accout.setSelection(defaultaccout.length());
        password.setText("cwj");

        login=(Button) findViewById(R.id.loginbutton);

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String saccout=accout.getText().toString();
                String spassword=password.getText().toString();
                if(saccout.equals("cwj")&&spassword.equals("cwj"))
                {
                    Intent intent=new Intent(LogActivity.this,MainActivity.class);

                    Toast.makeText(LogActivity.this,"Log in sucessfully~!",Toast.LENGTH_SHORT).show();
                    intent.putExtra("logged","succeed");
                    startActivity(intent);
                    finish();
                }
                else {
                    AlertDialog.Builder dialog=new AlertDialog.Builder(LogActivity.this);
                    dialog.setMessage("Your accout or password is wrong,please try again~!");
                    dialog.setCancelable(true);
                    dialog.setIcon(R.drawable.b);
                    dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog,int which)
                        {}
                    });
                    dialog.show();
                }
            }
        });

      //  login.callOnClick();

    }
    protected void onDestroy(){
        super.onDestroy();
        ActvitiyCollector.removeActivity(this);
    }
}
