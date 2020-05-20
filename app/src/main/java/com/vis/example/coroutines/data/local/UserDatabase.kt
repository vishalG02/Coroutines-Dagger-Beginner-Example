package com.vis.example.coroutines.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vis.example.coroutines.data.local.dao.UserDao
import com.vis.example.coroutines.data.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}