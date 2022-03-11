package com.fcossetta.githubrest.di

import androidx.room.Room
import com.fcossetta.githubrest.MyApplication
import com.fcossetta.githubrest.model.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule() {

    @Provides
    @Singleton
    fun provideDatabase(application: MyApplication): AppDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java, "users-db"
        ).build()
    }

}