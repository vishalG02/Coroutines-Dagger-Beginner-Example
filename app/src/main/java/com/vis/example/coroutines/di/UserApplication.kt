package com.vis.example.coroutines.di

import android.app.Application
import com.vis.example.coroutines.di.module.DatabaseModule
import com.vis.example.coroutines.di.module.NetworkModule


class UserApplication : Application() {


    //These instances should be declared only once throughout the entire lifespan of the application
    private var mAppComponent: UserComponent? = null

    override fun onCreate() {
        super.onCreate()
        if (mAppComponent == null) {
            mAppComponent = DaggerUserComponent.builder()
                .networkModule(NetworkModule())
                .databaseModule(DatabaseModule(this))
                .build()
        }

    }

    fun getAppComponent(): UserComponent? {
        return mAppComponent
    }


}