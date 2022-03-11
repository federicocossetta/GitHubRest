package com.fcossetta.githubrest.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fcossetta.githubrest.MyApplication
import com.fcossetta.githubrest.R
import com.fcossetta.githubrest.api.GitHubService
import com.fcossetta.githubrest.model.AppDatabase
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionKey
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LoginFragment : Fragment() {


    @Inject
    lateinit var gitHubService: GitHubService
    @Inject
    lateinit var appDatabase: AppDatabase

    private lateinit var viewModel: LoginViewModel
    lateinit var myApplication: MyApplication
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

}