package com.vis.example.coroutines.data.api

import com.vis.example.coroutines.data.model.ApiUser
import retrofit2.http.GET

interface UserWebService {

    @GET("users")
    suspend fun getUsers(): List<ApiUser>

    @GET("more-users")
    suspend fun getMoreUsers(): List<ApiUser>

    @GET("error")
    suspend fun getUsersWithError(): List<ApiUser>

}