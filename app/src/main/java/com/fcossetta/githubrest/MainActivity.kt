package com.fcossetta.githubrest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.fcossetta.githubrest.api.GitHubService
import com.fcossetta.githubrest.model.AppDatabase
import com.fcossetta.githubrest.ui.LoadingFragmentDirections
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasAndroidInjector {

    private lateinit var navHostFragment: NavHostFragment

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var api: GitHubService

    @Inject
    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val flags =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        window?.decorView?.systemUiVisibility = flags
        supportActionBar?.hide()
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        AndroidInjection.inject(this)
        lifecycleScope.launch(Dispatchers.IO) {
            db.userDao().users?.let {
                if (it.isNotEmpty()) {
                    it.get(0)?.let { user ->
                        val token = user.token
                        token
                    }
                } else {
                    runBlocking(Dispatchers.Main) {
                        val navBuilder: NavOptions.Builder = NavOptions.Builder()
                        val navOptions: NavOptions = navBuilder.setLaunchSingleTop(true).build()
                        navHostFragment.navController.navigate(
                            LoadingFragmentDirections
                                .actionLoadingToLoginFragment(), navOptions
                        )
                    }

                }
            }
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}