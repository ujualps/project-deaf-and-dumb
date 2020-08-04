package com.example.login111.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login111.R;

import pl.droidsonroids.gif.GifImageView;


public class GifAlbumAdapter extends RecyclerView.Adapter<GifAlbumAdapter.GifViewHolder> {

    private int [] gifs;
    private String[] titles={"Good afternoon","Good evening","Good morning","Good night","Sleep","Hello/Hi","Time"};
    private onGifListener mongifListener;


    public GifAlbumAdapter(int[] gifs, onGifListener mongifListener)
    {
        this.gifs = gifs;
        this.mongifListener = mongifListener;
    }

    @NonNull
    @Override
    public GifViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gif_album_layut,viewGroup,false);
        GifViewHolder gifViewHolder = new GifViewHolder(view,mongifListener);

        return gifViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GifViewHolder viewHolder, int i) {

        int gifid = gifs[i];
        viewHolder.gifImageView.setImageResource(gifid);
        viewHolder.textView.setText(titles[i]);

    }

    @Override
    public int getItemCount() {
        return gifs.length;
    }

    public static class GifViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        GifImageView gifImageView;
        TextView textView;
        onGifListener ongifListener;


        public GifViewHolder(@NonNull View itemView, onGifListener ongifListener) {
            super(itemView);

            gifImageView = itemView.findViewById(R.id.gif_album);
            textView = itemView.findViewById(R.id.gif_album_title);
            this.ongifListener = ongifListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ongifListener.onGifClick(getAdapterPosition());
        }
    }

    public interface onGifListener{

        void onGifClick(int position);
    }
}
