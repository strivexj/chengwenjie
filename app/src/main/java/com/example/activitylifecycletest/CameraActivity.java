package com.example.activitylifecycletest;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CameraActivity extends AppCompatActivity {
        public static final int TAKE_PHOTO = 1;
        public static final int CROP_PHOTO = 2;
        private Button takePhoto;
        private ImageView picture;
        private Uri imageUri;
        private  File outputImage1;
        private final File outputImage2=new File(Environment.
            getExternalStorageDirectory(), "tempImage2.jpg");
        private static final String TAG = "CameraActivity";

        protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_camera);
                ActvitiyCollector.addActivity(this);
                takePhoto = (Button) findViewById(R.id.button_take);
                Button choosephoto=(Button)findViewById(R.id.button_choose) ;
                picture = (ImageView) findViewById(R.id.image);
            if (ContextCompat.checkSelfPermission(CameraActivity.this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED) {
                //请求权限
                ActivityCompat.requestPermissions(CameraActivity.this,
                        new String[]{Manifest.permission.CAMERA},1);
            }

                takePhoto.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            outputImage1=new File(Environment.
                                    getExternalStorageDirectory(), "tempImage1.jpg");
                               try {
                                    if (outputImage1.exists()) {
                                        // if (outputImage1.exists()) {

                                        imageUri = Uri.fromFile(outputImage1);
           /* }
            if(outputImage2.exists())
                imageUri = Uri.fromFile(outputImage1);
            if(outputImage1.exists()||outputImage2.exists()) {*/
                                        try {
                                            Bitmap bitmap = BitmapFactory.decodeStream
                                                    (getContentResolver()
                                                            .openInputStream(imageUri));
                                            picture.setImageBitmap(bitmap);
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                        // }
                                        outputImage1.delete();
                                    }
                                    outputImage1.createNewFile();
                                   // outputImage1.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                imageUri = Uri.fromFile(outputImage1);
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                                startActivityForResult(intent, TAKE_PHOTO); // 启动相机程序
                        }
                });
            choosephoto.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    File outputImage = new File(Environment.
                            getExternalStorageDirectory(), "output_image.jpg");
                    try {
                        if (outputImage.exists()) {
                            outputImage.delete();
                        }
                        outputImage.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageUri = Uri.fromFile(outputImage);
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");//相片类型
                    intent.putExtra("crop", true);
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 3);
                }
            });
        }
    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                switch (requestCode) {
                        case TAKE_PHOTO:

                                if (resultCode == RESULT_OK) {
                                        Intent intent = new Intent("com.android.camera.action.CROP");
                                        intent.setDataAndType(imageUri, "image/*");
                                        intent.putExtra("scale", true);
                                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                                        startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序
                                }
                                break;
                        case CROP_PHOTO:
                                if (resultCode == RESULT_OK) {
                                        try {
                                                Bitmap bitmap = BitmapFactory.decodeStream
                                                        (getContentResolver()
                                                                .openInputStream(imageUri));
                                                picture.setImageBitmap(bitmap); // 将裁剪后的照片显示出来
                                        } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                        }
                                }
                                break;
                    case 3:
                        if (resultCode == RESULT_OK) {
                           try {
                                Uri uri = data.getData();
                              Bitmap bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                               bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                                picture.setImageBitmap(bit);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                        default:
                                break;
                }
        }
}