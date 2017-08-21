package com.example.mylibrary.dagger;


import android.content.Context;

import com.example.mylibrary.Activity.ProntoShopApplication;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/*** Created by nikita on 16/08/2017..
 */

@Module
public class AppModule {
    private final ProntoShopApplication app;

    public AppModule(ProntoShopApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    // TODO: 16/8/17 This class is particular module provides the Context.
    public Context provideContext() {
        return app;
    }
}

