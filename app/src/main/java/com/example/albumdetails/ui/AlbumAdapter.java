package com.example.albumdetails.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.albumdetails.R;
import com.example.albumdetails.model.Album;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewholder> {

    List<Album> albumList = new ArrayList<>();

    @NonNull
    @Override
    public AlbumViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cardview, parent, false);
        return new AlbumViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewholder holder, int position) {
        holder.bind(albumList.get(position));
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public void setItems(List<Album> albums) {
        if (!albumList.isEmpty()) {
            albumList.clear();
        }
        albumList.addAll(albums);
        Collections.sort(albumList, new Comparator<Album>() {
            @Override
            public int compare(Album lhs, Album rhs) {
                return lhs.getTitle().compareTo(rhs.getTitle());
            }
        });
        notifyDataSetChanged();
    }

}
