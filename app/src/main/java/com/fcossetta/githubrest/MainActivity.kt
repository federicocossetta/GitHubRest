package com.fcossetta.githubrest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.fcossetta.githubrest.api.GitHubService
import com.fcossetta.githubrest.model.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment

    @Inject
    lateinit var api: GitHubService

    @Inject
    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val apiComponent = (application as MyApplication).apiComponent
        apiComponent.inject(this)
        lifecycleScope.launch(Dispatchers.IO) {
            db.userDao().users?.let {
                if (it.isNotEmpty()) {
                    it.get(0)?.let { user ->
                        val token = user.token
                        token
                    }
                } else {
                    runBlocking(Dispatchers.Main) {
                        navHostFragment.navController.navigate(R.id.action_loading_to_loginFragment)
                    }

                }
            }
        }
    }
}