package com.vis.example.coroutines.di.module

import android.app.Application
import androidx.room.Room
import com.vis.example.coroutines.data.api.UserWebService
import com.vis.example.coroutines.data.local.UserDatabase
import com.vis.example.coroutines.utils.UserRepository
import com.vis.example.coroutines.utils.UserViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(val application: Application) {

    private val userDatabase: UserDatabase = Room.databaseBuilder(
        application,
        UserDatabase::class.java,
        "UserDatabase"
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideUserRepository(app: Application,userDatabase: UserDatabase, userWebService: UserWebService): UserRepository {
        return UserRepository(userDatabase,
            userWebService
        )
    }

    @Provides
    @Singleton
    fun provideUserViewModelFactory(userRepository: UserRepository): UserViewModelFactory {
        return UserViewModelFactory(userRepository)
    }
    @Provides
    @Singleton
    fun provideUserDatabase(): UserDatabase {
        return userDatabase
    }

}
