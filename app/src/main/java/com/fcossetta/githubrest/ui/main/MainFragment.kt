package com.fcossetta.githubrest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.fcossetta.githubrest.R
import com.fcossetta.githubrest.api.GitHubService
import retrofit2.Retrofit

class MainFragment(val api: GitHubService, val navHostFragment: NavHostFragment) : Fragment() {
    lateinit var retrofit: Retrofit

    companion object {
        fun newInstance(api: GitHubService, navHostFragment: NavHostFragment) = MainFragment(
            api,
            navHostFragment
        )
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
        }
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }
}

