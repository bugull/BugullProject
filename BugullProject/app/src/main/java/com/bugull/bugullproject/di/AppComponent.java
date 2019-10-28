package com.bugull.bugullproject.di;

import android.app.Application;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by cj on 2019-10-23.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Application getApp();
}
