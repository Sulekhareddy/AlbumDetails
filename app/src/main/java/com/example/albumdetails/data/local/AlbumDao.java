package com.example.albumdetails.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.albumdetails.model.Album;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface AlbumDao {

    @Query("SELECT * FROM album_table")
    Single<List<Album>> getAlbumList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAlbums(List<Album> albums);
}
