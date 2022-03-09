package com.fcossetta.githubrest.api

import com.fcossetta.githubrest.model.Repo


class ApiHelper(private val apiService: GitHubService) {

    suspend fun getBeersByDate(from: String, to: String, page: Int): List<Repo> =
        apiService.getRepos()
}