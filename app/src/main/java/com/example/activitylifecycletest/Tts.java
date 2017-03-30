package com.example.activitylifecycletest;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by 10032 on 2017/2/4.
 */

public class Tts {
    private static TextToSpeech tts;
    public  static void speak(final Context context,final String string) {

        tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.UK);
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(context, "TTS暂时不支持这种语言的朗读.", Toast.LENGTH_SHORT).show();
                    }
                }
                try{
                    tts.speak(string, TextToSpeech.QUEUE_ADD, null, "speech");
                }catch (  Exception e) {}

            }
        });
    }
    public  static void close(){
        tts.shutdown();
    }
}
