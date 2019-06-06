package com.example.albumdetails.di.component;

import android.content.Context;

import com.example.albumdetails.data.Repository;
import com.example.albumdetails.di.module.ApplicationModule;
import com.example.albumdetails.di.module.DatabaseModule;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

@Singleton
@Component(modules = {ApplicationModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    // Expose to sub-graphs
    Context context();
    Repository repository();
    CompositeDisposable compositeDisposable();
}
