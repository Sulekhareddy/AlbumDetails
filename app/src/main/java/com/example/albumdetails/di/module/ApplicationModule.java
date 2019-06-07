package com.example.albumdetails.di.module;

import android.content.Context;

import com.example.albumdetails.AlbumApp;
import com.example.albumdetails.data.Repository;
import com.example.albumdetails.data.local.AlbumDao;
import com.example.albumdetails.data.remote.AlbumService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private final AlbumApp app;

    public ApplicationModule(AlbumApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    Repository provideRepository(AlbumService albumService, AlbumDao albumDao) {
        return new Repository(albumService, albumDao);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    AlbumService provideAlbumService(Retrofit retrofit) {
        return retrofit.create(AlbumService.class);
    }

    @Provides
    @Singleton
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
