package com.fcossetta.githubrest

import android.app.Activity
import android.app.Application
import android.content.pm.ApplicationInfo
import com.fcossetta.githubrest.di.DaggerApiComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector  {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerApiComponent.builder().application(this).baseUrl("https://api.github.com").build()
            .inject(this)
    }


    override fun getApplicationInfo(): ApplicationInfo {
        return super.getApplicationInfo()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}
