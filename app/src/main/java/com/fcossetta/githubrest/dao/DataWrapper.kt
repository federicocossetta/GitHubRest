package com.fcossetta.githubrest.dao

class DataWrapper<T> {
    var data: T? = null
    var error //or A message String, Or whatever
            : Throwable? = null

    fun isSuccess(): Boolean {
        return error == null
    }
}