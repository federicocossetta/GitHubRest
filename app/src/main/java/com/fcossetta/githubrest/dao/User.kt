package com.fcossetta.githubrest.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User {
    @PrimaryKey
    var uid = 0
    @ColumnInfo(name = "auth_token")
    var token: String? = null

}