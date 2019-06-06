package com.example.albumdetails.di.module;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.albumdetails.data.Repository;
import com.example.albumdetails.di.scopes.ActivityScope;
import com.example.albumdetails.ui.AlbumAdapter;
import com.example.albumdetails.ui.mvp.AlbumMvpContract;
import com.example.albumdetails.ui.mvp.AlbumPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class AlbumActivityModule {

    private final AlbumMvpContract.View view;

    public AlbumActivityModule(AlbumMvpContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public AlbumPresenter provideAlbumScreenPresenter(Repository repository, CompositeDisposable compositeDisposable) {
        return new AlbumPresenter(view, repository, compositeDisposable);
    }

    @Provides
    @ActivityScope
    public AlbumAdapter provideAlbumListAdapter(){
        return new AlbumAdapter();
    }

    @Provides
    @ActivityScope
    public LinearLayoutManager provideLinearLayoutManager(Context context){
        return new LinearLayoutManager(context);
    }
}
