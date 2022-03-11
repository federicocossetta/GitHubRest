package com.fcossetta.githubrest.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fcossetta.githubrest.dao.User

@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val users: List<User?>?

    @Insert
    fun insertAll(vararg users: User?)

    @Delete
    fun delete(user: User?)
}