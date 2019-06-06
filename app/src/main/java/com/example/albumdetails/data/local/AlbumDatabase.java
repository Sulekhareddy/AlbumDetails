package com.example.albumdetails.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.albumdetails.model.Album;

@Database(entities = Album.class, version = 1)
public abstract class AlbumDatabase extends RoomDatabase {

    public abstract AlbumDao albumDao();


}
