package com.example.albumdetails.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.albumdetails.R;
import com.example.albumdetails.model.Album;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumViewholder extends RecyclerView.ViewHolder {

    @BindView(R.id.title_text)
    TextView titleTextView;

    public AlbumViewholder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public  void bind(Album album) {

        titleTextView.setText(album.getTitle());
    }
}
