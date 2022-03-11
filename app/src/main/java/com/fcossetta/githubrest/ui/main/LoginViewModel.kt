package com.fcossetta.githubrest.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.fcossetta.githubrest.api.GitHubService
import kotlinx.coroutines.launch
import okhttp3.Credentials

class LoginViewModel : ViewModel() {

     fun login(gitHubService: GitHubService, user: String, pwd: String)  = liveData<String> {
        viewModelScope.launch {
            val basic = Credentials.basic(user, pwd)
            val userToken = gitHubService.getUserToken(basic)
            if(userToken.isSuccessful){
                emit(userToken.message())
            }
        }


    }
}