package com.fcossetta.githubrest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.fcossetta.githubrest.api.GitHubService
import com.fcossetta.githubrest.ui.main.MainFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment

    @Inject
    lateinit var api: GitHubService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val apiComponent = (application as MyApplication).apiComponent
        apiComponent.inject(this)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(api,navHostFragment))
                .commitNow()
        }
    }
}