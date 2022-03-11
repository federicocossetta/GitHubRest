package com.fcossetta.githubrest.di

import com.fcossetta.githubrest.ui.main.LoginFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.fcossetta.githubrest.ui.main.MainFragment

@Subcomponent
interface LoginFragmentSubcomponent : AndroidInjector<LoginFragment?> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<LoginFragment?>
}