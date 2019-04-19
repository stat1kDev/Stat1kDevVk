package com.example.stat1kdevvk.di.component;

import com.example.stat1kdevvk.di.module.ApplicationModule;
import com.example.stat1kdevvk.di.module.ManagerModule;
import com.example.stat1kdevvk.di.module.RestModule;
import com.example.stat1kdevvk.ui.activity.BaseActivity;
import com.example.stat1kdevvk.ui.activity.MainActivity;
import com.example.stat1kdevvk.ui.fragment.NewsFeedFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragments
    void inject(NewsFeedFragment fragment);
}
