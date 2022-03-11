package com.fcossetta.githubrest.ui.main

import androidx.lifecycle.ViewModel
import com.fcossetta.githubrest.api.GitHubService
import okhttp3.Credentials

class LoginViewModel : ViewModel() {

    suspend fun login(gitHubService: GitHubService, user: String, pwd: String) {
        val basic = Credentials.basic(user, pwd)
        val userToken = gitHubService.getUserToken(basic)
        if(userToken.isSuccessful){

        }
    }
}