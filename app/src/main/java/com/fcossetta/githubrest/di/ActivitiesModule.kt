package com.fcossetta.githubrest.di

import dagger.Binds
import dagger.multibindings.IntoMap
import com.fcossetta.githubrest.MainActivity
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey

@Module(subcomponents = [MainActivitySubcomponent::class])
internal abstract class ActivitiesModule {
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindYourAndroidInjectorFactory(factory: MainActivitySubcomponent.Factory?): AndroidInjector.Factory<*>?
}