package com.example.login111.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login111.R;

import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class FeatureFragment extends Fragment {
    Button blisten, bspeak, bimage;
    EditText etext;
    private TextToSpeech mTTS;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_feature, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bspeak = getView().findViewById(R.id.speak);
        etext = getView().findViewById(R.id.editText4);
        blisten = getView().findViewById(R.id.listen);
        bimage = getView().findViewById(R.id.image);

        mTTS = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
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





        bspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(),"dsfdsf",Toast.LENGTH_SHORT).show();
                String str = etext.getText().toString();
                if(!str.isEmpty())
                    speak();
                else
                    Toast.makeText(getContext(),"Text field empty.",Toast.LENGTH_SHORT).show();
            }
        });

        blisten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(intent, 10);
            }
        });

        bimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str =etext.getText().toString();
                if(!str.isEmpty())
                {
                    Intent intent = new Intent(getActivity().getApplication(),popup.class);
                    intent.putExtra("etext",etext.getText().toString());
                    startActivity(intent);
                }
                else
                    Toast.makeText(getContext(),"Text field empty.",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void speak(){
        String text = etext.getText().toString();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if(resultCode == RESULT_OK && data != null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    etext.setText(result.get(0));
                }
        }
    }

    @Override
    public void onDestroy() {
        if(mTTS != null)
        {
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();

    }
}
