package com.fcossetta.githubrest.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.fcossetta.githubrest.api.GitHubService
import com.fcossetta.githubrest.dao.DataWrapper
import com.fcossetta.githubrest.dao.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Credentials
import retrofit2.Response

class LoginViewModel : ViewModel() {

    fun login(gitHubService: GitHubService, user: String, pwd: String) =
        liveData {
            var userToken: Response<String>? = null
            withContext(Dispatchers.IO) {
                val basic = Credentials.basic(user, pwd)
                userToken = gitHubService.getUserToken(basic)
            }
            val data: DataWrapper<String> = DataWrapper()
            userToken?.let {
                if (it.isSuccessful) {
                    it.body()?.let { token ->
                        {
                            data.data = token
                        }
                    }
                } else {
                    data.error = Exception(it.errorBody().toString())
                }
            }
            emit(data)
        }

    fun fetchRepos(gitHubService: GitHubService, token: String) =
        liveData {
            val repos: Response<List<Repo>>
            withContext(Dispatchers.IO) {
                repos = gitHubService.getRepos(token)
            }
            val data: DataWrapper<List<Repo>> = DataWrapper()
            if (repos.isSuccessful) {
                repos.body()?.let {
                    data.data?.toMutableList()?.addAll(it.toMutableList())
                }
            } else {
                data.error = Exception(repos.errorBody().toString())
            }
            emit(data)
        }
}