package com.vis.example.coroutines.data.api

import com.vis.example.coroutines.data.model.ApiUser
import retrofit2.http.GET

interface UserWebService {

    @GET("concepts")
    suspend fun getUsers(): List<ApiUser>

}