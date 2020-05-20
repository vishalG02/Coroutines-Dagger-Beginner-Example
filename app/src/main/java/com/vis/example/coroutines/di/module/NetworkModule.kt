package com.vis.example.coroutines.di.module

import com.vis.example.coroutines.data.api.UserWebService

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getUserServiceInterface(retroFit: Retrofit): UserWebService {
        return retroFit.create<UserWebService>(UserWebService::class.java!!)
    }

    @Provides
    @Singleton
    fun getRetrofit(baseurl:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideBaseUrl(): String {
        return "https://5e510330f2c0d300147c034c.mockapi.io/"
    }

}