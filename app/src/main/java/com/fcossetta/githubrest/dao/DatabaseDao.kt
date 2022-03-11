package com.fcossetta.githubrest.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao {

    @Query("SELECT * FROM databases WHERE auth_token LIKE :query")
    fun databases(query: String): List<Database?>?

    @Insert
    fun insertAll(vararg users: Database?)

    @Delete
    fun delete(user: Database?)
}