package com.fcossetta.githubrest.di

import com.fcossetta.githubrest.ui.main.LoginFragment
import com.fcossetta.githubrest.ui.main.MainFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainFragmentSubcomponent::class, LoginFragmentSubcomponent::class])
internal abstract class FragmentsModule {
    @Binds
    @IntoMap
    @ClassKey(MainFragment::class)
    abstract fun provideMainFragment(factory: MainFragmentSubcomponent.Factory?): AndroidInjector.Factory<*>?

    @Binds
    @IntoMap
    @ClassKey(LoginFragment::class)
    abstract fun provideLoginFragment(factory: LoginFragmentSubcomponent.Factory?): AndroidInjector
    .Factory<*>?
}