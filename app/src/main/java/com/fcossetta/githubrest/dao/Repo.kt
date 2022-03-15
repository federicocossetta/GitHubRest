package com.fcossetta.githubrest.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "databases")
class Repo {
    @PrimaryKey
    var uid = 0

    @ColumnInfo(name = "auth_token")
    var token: String? = null

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "starred")
    var starred: Boolean? = null

}