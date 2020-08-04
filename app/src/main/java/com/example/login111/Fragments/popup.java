package com.example.login111.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.login111.R;

import java.util.Locale;



public class popup extends Activity {

    Button bspeak;
    protected ImageView iv;
    String stext;
    private TextToSpeech mTTS;

    int n = 0;
    String temp;
    Boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(0.8*width),(int)(height*0.5));

        bspeak = findViewById(R.id.speak);

        iv = findViewById(R.id.imageView);

        iv.setImageResource(R.drawable.imagenotavailable);

        Intent i = getIntent();
        stext = i.getStringExtra("etext");
//        Toast.makeText(getApplicationContext(),stext,Toast.LENGTH_SHORT).show();

        mTTS = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = mTTS.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED ){
                        Log.e("TTS","Language not supported");
                    }else{
                        bspeak.setEnabled(true);
                    }
                }else {
                    Log.e("TTS","initialisation failed");
                }
            }
        });

        n = 0;
        flag = setImage(stext);
        if(flag)
            n = stext.length();

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

//        String temp;



//        temp = stext;
//        Toast.makeText(this, temp.substring(2), Toast.LENGTH_SHORT).show();
                if(n < stext.length()){

                    temp = stext.substring(n);
//            try{
//                Thread.sleep(2000);
//            }catch (Exception e){
//
//            }
                    flag = setImage(temp);
                    if(flag){
                        n += temp.length();
                    }


                    while(n < stext.length()){
                        temp = temp.substring(0,temp.length()-1);



                        flag = setImage(temp);
                        Log.d("value of n.\n", "n: " + n);
                        if(flag)
                        {
                            n += temp.length();
                            Log.d("value of n after.\n", "n: "+n);
                            if (temp.equals(" ")) {
//                                Toast.makeText(popup.this, "space", Toast.LENGTH_SHORT).show();
                                handler.postDelayed(this, 20);
                            }
                            else if(temp.length() == 1){
                                handler.postDelayed(this, 1000);
                            }
                            else
                                handler.postDelayed(this, 2000);
                            break;
                        }

                    }
                }
            }
        };
        handler.postDelayed(runnable,2000);






        bspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();
            }
        });
    }
    private void speak(){
        mTTS.speak(stext, TextToSpeech.QUEUE_FLUSH,null);
    }


    Boolean setImage(String string){
        if( string.equalsIgnoreCase("i love you"))
        {
            iv.setImageResource(R.drawable.iloveu);
        }
        else if(string.equalsIgnoreCase("hello")||string.equalsIgnoreCase("hi"))
        {
            iv.setImageResource(R.drawable.hello);
        }
        else if(string.equalsIgnoreCase("slept")||string.equalsIgnoreCase("slept?"))
        {
            iv.setImageResource(R.drawable.sleep);
        }
        else if(string.equalsIgnoreCase("hungry"))
        {
            iv.setImageResource(R.drawable.hungry2);
        }
        else if(string.equalsIgnoreCase("good morning")||string.equalsIgnoreCase("gm"))
        {
            iv.setImageResource(R.drawable.gm);
        }
        else if(string.equalsIgnoreCase("good afternoon")||string.equalsIgnoreCase("ga"))
        {
            iv.setImageResource(R.drawable.ga);
        }
        else if(string.equalsIgnoreCase("good night")||string.equalsIgnoreCase("gn"))
        {
            iv.setImageResource(R.drawable.gn);
        }
        else if(string.equalsIgnoreCase("good evening")||string.equalsIgnoreCase("ge"))
        {
            iv.setImageResource(R.drawable.ge);
        }
        else if(string.equalsIgnoreCase("diarrhea"))
        {
            iv.setImageResource(R.drawable.diarrhea);
        }
        else if(string.equalsIgnoreCase("time")||string.equalsIgnoreCase("tm"))
        {
            iv.setImageResource(R.drawable.giphy);
        }
        else if(string.equalsIgnoreCase("a"))
        {
            iv.setImageResource(R.drawable.a);
        }
        else if(string.equalsIgnoreCase("b"))
        {
            iv.setImageResource(R.drawable.b);
        }
        else if(string.equalsIgnoreCase("c"))
        {
            iv.setImageResource(R.drawable.c);
        }
        else if(string.equalsIgnoreCase("d"))
        {
            iv.setImageResource(R.drawable.d);
        }
        else if(string.equalsIgnoreCase("e"))
        {
            iv.setImageResource(R.drawable.e);
        }
        else if(string.equalsIgnoreCase("f"))
        {
            iv.setImageResource(R.drawable.f);
        }
        else if(string.equalsIgnoreCase("g"))
        {
            iv.setImageResource(R.drawable.g);
        }
        else if(string.equalsIgnoreCase("h"))
        {
            iv.setImageResource(R.drawable.h);
        }
        else if(string.equalsIgnoreCase("i"))
        {
            iv.setImageResource(R.drawable.i);
        }
        else if(string.equalsIgnoreCase("j"))
        {
            iv.setImageResource(R.drawable.j);
        }
        else if(string.equalsIgnoreCase("k"))
        {
            iv.setImageResource(R.drawable.k);
        }
        else if(string.equalsIgnoreCase("l"))
        {
            iv.setImageResource(R.drawable.l);
        }
        else if(string.equalsIgnoreCase("m"))
        {
            iv.setImageResource(R.drawable.m);
        }
        else if(string.equalsIgnoreCase("n"))
        {
            iv.setImageResource(R.drawable.n);
        }else if(string.equalsIgnoreCase("o"))
        {
            iv.setImageResource(R.drawable.o);
        }else if(string.equalsIgnoreCase("p"))
        {
            iv.setImageResource(R.drawable.p);
        }else if(string.equalsIgnoreCase("q"))
        {
            iv.setImageResource(R.drawable.q);
        }else if(string.equalsIgnoreCase("r"))
        {
            iv.setImageResource(R.drawable.r);
        }else if(string.equalsIgnoreCase("s"))
        {
            iv.setImageResource(R.drawable.s);
        }else if(string.equalsIgnoreCase("t"))
        {
            iv.setImageResource(R.drawable.t);
        }else if(string.equalsIgnoreCase("u"))
        {
            iv.setImageResource(R.drawable.u);
        }
        else if(string.equalsIgnoreCase("v"))
        {
            iv.setImageResource(R.drawable.v);
        }else if(string.equalsIgnoreCase("w"))
        {
            iv.setImageResource(R.drawable.w);
        }else if(string.equalsIgnoreCase("x"))
        {
            iv.setImageResource(R.drawable.x);
        }
        else if(string.equalsIgnoreCase("y"))
        {
            iv.setImageResource(R.drawable.y);
        }
        else if(string.equalsIgnoreCase("z"))
        {
            iv.setImageResource(R.drawable.z);
        }

        else if(string.length() == 1)
        {
//            Toast.makeText(this, "one char", Toast.LENGTH_SHORT).show();
        }
        else{
//            iv.setImageResource(R.drawable.imagenotavailable);
            return false;
        }
        return true;
    }
}
