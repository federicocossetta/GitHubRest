package com.fcossetta.githubrest

import android.app.Application
import android.content.pm.ApplicationInfo
import com.fcossetta.githubrest.di.ApiComponent
import com.fcossetta.githubrest.di.DaggerApiComponent

class MyApplication : Application() {


    val apiComponent: ApiComponent by lazy {
        DaggerApiComponent.builder().application(this).build()
    }

    override fun getApplicationInfo(): ApplicationInfo {
        return super.getApplicationInfo()
    }
}
