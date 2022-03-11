package com.fcossetta.githubrest.di

import com.fcossetta.githubrest.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApiModule::class, DatabaseModule::class, AndroidInjectionModule::class,
        ActivitiesModule::class, FragmentsModule::class]
)
interface ApiComponent : AndroidInjector<MyApplication> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        @BindsInstance
        fun baseUrl(baseUrl: String): Builder

        fun build(): ApiComponent

    }

}