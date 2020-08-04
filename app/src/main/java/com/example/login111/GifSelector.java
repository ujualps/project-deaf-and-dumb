package com.example.login111;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.Toast;


import com.example.login111.Adapter.GifAlbumAdapter;

import java.util.Locale;

public class GifSelector extends AppCompatActivity implements GifAlbumAdapter.onGifListener {

    private RecyclerView recyclerView;

    private int[] gifs = {R.drawable.ga,R.drawable.ge,R.drawable.gm,R.drawable.gn,R.drawable.sleep,R.drawable.hello,R.drawable.giphy};
    private String[] titles={"Good afternoon","Good evening","Good morning","Good night","Sleep","Hello","Time"};

    private RecyclerView.LayoutManager layoutManager; //The adapter for Recycler View

    private GifAlbumAdapter adapter;


    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_selector);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(0.8*width),(int)(height*0.81));


        Intent intent = getIntent();
        userid = intent.getStringExtra("userid");

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new GifAlbumAdapter(gifs,this);

        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onGifClick(int position) {
//        Toast.makeText(this, titles[position], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.putExtra("userid", userid);
        intent.putExtra("etext", titles[position]);
        startActivity(intent);

    }
}
