package com.vis.example.coroutines.utils


import com.vis.example.coroutines.data.api.ApiHelper
import com.vis.example.coroutines.data.api.UserWebService
import com.vis.example.coroutines.data.local.DatabaseHelper
import com.vis.example.coroutines.data.local.UserDatabase
import com.vis.example.coroutines.data.local.entity.User


class UserRepository(private val userDatabase: UserDatabase, private val userWebService: UserWebService):ApiHelper,DatabaseHelper  {

    override suspend fun getUsers() = userWebService.getUsers()

    override suspend fun getMoreUsers() = userWebService.getUsers()

    override suspend fun getUsersWithError() = userWebService.getUsers()

    override suspend fun getUsersFromDb(): List<User> = userDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<User>) = userDatabase.userDao().insertAll(users)


}
