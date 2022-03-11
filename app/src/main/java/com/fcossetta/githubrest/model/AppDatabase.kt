package com.fcossetta.githubrest.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fcossetta.githubrest.dao.DatabaseDao
import com.fcossetta.githubrest.dao.User
import com.fcossetta.githubrest.dao.UserDao

@Database(entities = [User::class,com.fcossetta.githubrest.dao.Database::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun databaseDao(): DatabaseDao
}