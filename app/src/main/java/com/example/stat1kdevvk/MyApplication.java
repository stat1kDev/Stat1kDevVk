package com.example.stat1kdevvk;

import android.app.Application;

import com.vk.sdk.VKSdk;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        VKSdk.initialize(this);
    }
}
