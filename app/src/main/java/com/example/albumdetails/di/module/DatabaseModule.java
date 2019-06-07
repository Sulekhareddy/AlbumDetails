package com.example.albumdetails.di.module;

import androidx.room.Room;

import com.example.albumdetails.AlbumApp;
import com.example.albumdetails.data.local.AlbumDao;
import com.example.albumdetails.data.local.AlbumDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    private final AlbumApp albumApp;

    public DatabaseModule(AlbumApp albumApp) {
        this.albumApp = albumApp;
    }

    @Provides
    @Singleton
    AlbumDatabase provideAlbumDatabase() {
        return Room.databaseBuilder(albumApp, AlbumDatabase.class, "album_db").build();
    }

    @Provides
    @Singleton
    AlbumDao provideAlbumDao(AlbumDatabase albumDatabase) {
        return albumDatabase.albumDao();
    }
}
