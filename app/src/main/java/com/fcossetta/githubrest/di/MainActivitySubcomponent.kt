package com.fcossetta.githubrest.di

import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.fcossetta.githubrest.MainActivity

@Subcomponent
interface MainActivitySubcomponent : AndroidInjector<MainActivity?> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity?>
}