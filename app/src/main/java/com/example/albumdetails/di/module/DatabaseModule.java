package com.example.albumdetails.di.module;

import androidx.room.Room;

import com.example.albumdetails.UserApp;
import com.example.albumdetails.data.local.AlbumDao;
import com.example.albumdetails.data.local.AlbumDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    private final UserApp userApp;

    public DatabaseModule(UserApp userApp) {
        this.userApp = userApp;
    }

    @Provides
    @Singleton
    AlbumDatabase provideAlbumDatabase() {
        return Room.databaseBuilder(userApp, AlbumDatabase.class, "album_db").build();
    }

    @Provides
    @Singleton
    AlbumDao provideAlbumDao(AlbumDatabase albumDatabase) {
        return albumDatabase.albumDao();
    }
}
