package com.fcossetta.githubrest.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RepoDao {

    @Query("SELECT * FROM databases WHERE auth_token LIKE :query")
    fun databases(query: String): List<Repo?>?

    @Insert
    fun insertAll(vararg users: Repo?)

    @Delete
    fun delete(user: Repo?)
}