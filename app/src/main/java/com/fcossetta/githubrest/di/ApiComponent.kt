package com.fcossetta.githubrest.di

import com.fcossetta.githubrest.MainActivity
import com.fcossetta.githubrest.MyApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, DatabaseModule::class])
interface ApiComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        @BindsInstance
        fun baseUrl(baseUrl: String): Builder

        fun build(): ApiComponent

    }

    fun inject(activity: MainActivity?)
}