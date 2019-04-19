package com.example.stat1kdevvk;

import android.app.Application;

import com.example.stat1kdevvk.di.component.ApplicationComponent;
import com.example.stat1kdevvk.di.component.DaggerApplicationComponent;
import com.example.stat1kdevvk.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();

        VKSdk.initialize(this);
    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getsApplicationComponent() {
        return sApplicationComponent;
    }
}
