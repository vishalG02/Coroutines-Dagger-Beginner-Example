package com.vis.example.coroutines.data.local

import com.vis.example.coroutines.data.local.entity.User

interface DatabaseHelper {

    suspend fun getUsersFromDb(): List<User>

    suspend fun insertAll(users: List<User>)

}