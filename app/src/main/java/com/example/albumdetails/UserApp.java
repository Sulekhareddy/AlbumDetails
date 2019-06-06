package com.example.albumdetails;

import android.app.Application;
import android.content.Context;

import com.example.albumdetails.di.component.ApplicationComponent;
import com.example.albumdetails.di.component.DaggerApplicationComponent;
import com.example.albumdetails.di.module.ApplicationModule;
import com.example.albumdetails.di.module.DatabaseModule;

public class UserApp extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();
    }

    public static UserApp getInstance(Context context) {
        return (UserApp) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
