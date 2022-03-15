package com.fcossetta.githubrest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fcossetta.githubrest.api.GitHubService
import com.fcossetta.githubrest.dao.User
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
            performLogin()
        }

    }

    private fun performLogin() {
        viewModel.login(
            gitHubService, binding.username.editText!!.text.toString(), binding.passwod
                .editText!!.text.toString()
        ).observe(
            viewLifecycleOwner, Observer {
                if (it.isSuccess()) {
                    val user = User()
                    user.token = it.data
                    appDatabase.userDao().insertAll(user)
                    fetchRepos(user)
                } else {
                    Toast.makeText(context, "An error has occurred, retry", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    private fun fetchRepos(user: User) {
        user.token?.let {
            viewModel.fetchRepos(gitHubService, it).observe(viewLifecycleOwner) { data ->
                run {
                    if (data.isSuccess()) {
                        data.data?.toTypedArray()
                            ?.forEach { repo -> appDatabase.databaseDao().insertAll(repo) }
                    } else {
                        Toast.makeText(context, "An error has occurred, retry", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }

        }
    }

}