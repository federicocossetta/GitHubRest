package com.fcossetta.githubrest.api

import com.fcossetta.githubrest.model.Repo
import retrofit2.http.GET
import retrofit2.http.Header

interface GitHubService {

    @GET("v2/beers")
    suspend fun getRepos(
    ): List<Repo>

    @GET("user")
    suspend fun getUserToken(@Header("Autorization") h1: String): String
}