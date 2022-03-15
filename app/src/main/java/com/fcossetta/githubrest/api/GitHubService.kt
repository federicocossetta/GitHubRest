package com.fcossetta.githubrest.api

import com.fcossetta.githubrest.dao.Repo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface GitHubService {

    @GET("user/repos")
    suspend fun getRepos(@Header("Authorization") token: String
    ): Response<List<Repo>>

    @GET("user")
    suspend fun getUserToken(@Header("Authorization") authorization: String): Response<String>
}