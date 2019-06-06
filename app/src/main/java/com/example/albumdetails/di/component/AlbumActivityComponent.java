package com.example.albumdetails.di.component;

import com.example.albumdetails.di.module.AlbumActivityModule;
import com.example.albumdetails.di.scopes.ActivityScope;
import com.example.albumdetails.ui.AlbumScreenActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = AlbumActivityModule.class)
public interface AlbumActivityComponent {

    void inject(AlbumScreenActivity AlbumScreenActivity);
}
