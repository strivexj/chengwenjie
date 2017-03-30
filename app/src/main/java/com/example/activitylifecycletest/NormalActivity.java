package com.example.activitylifecycletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class NormalActivity extends AppCompatActivity {
    protected void onDestroy(){
        super.onDestroy();
        ActvitiyCollector.removeActivity(this);
    }
private boolean a=true;
    private static final String TAG = "NormalActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActvitiyCollector.addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Button button=(Button)findViewById(R.id.button_4);
        final ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressbar);
         final ImageView image=(ImageView)findViewById(R.id.image1);
        final EditText editText=(EditText)findViewById(R.id.edit_text1) ;

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String inputtext=editText.getText().toString();
                Toast.makeText(NormalActivity.this,inputtext,Toast.LENGTH_SHORT).show();
               int progress=progressBar.getProgress();
                if(progress!=100)
                 progress+=10;
                else
                progress-=100;
                progressBar.setProgress(progress);

                /*if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
*/
               if(a==true) {
                    image.setImageResource(R.drawable.a);
                    a=false;
                }
                else {
                    image.setImageResource(R.drawable.b);
                    a=true;
                }

            }
        });
    }
}
