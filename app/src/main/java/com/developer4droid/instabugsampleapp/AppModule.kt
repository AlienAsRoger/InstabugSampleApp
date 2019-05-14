package com.developer4droid.instabugsampleapp

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class AppModule {

    @Provides
    internal fun provideContext(application: MyApplication): Context {
        return application.applicationContext
    }

}