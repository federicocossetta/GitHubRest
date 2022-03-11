package com.fcossetta.githubrest.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fcossetta.githubrest.api.GitHubService
import com.fcossetta.githubrest.databinding.LoginFragmentBinding
import com.fcossetta.githubrest.model.AppDatabase
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LoginFragment : Fragment() {


    private var _binding: LoginFragmentBinding? = null

    private val TAG: String = "AAA"

    @Inject
    lateinit var gitHubService: GitHubService

    @Inject
    lateinit var appDatabase: AppDatabase

    private lateinit var viewModel: LoginViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginButton.setOnClickListener {
            viewModel.login(
                gitHubService, binding.username.editText!!.text.toString(), binding.passwod
                    .editText!!.text.toString()
            ).observe(
                viewLifecycleOwner
            ) {
                Log.e(TAG, "onActivityCreated: $it")
            }
        }

    }

}