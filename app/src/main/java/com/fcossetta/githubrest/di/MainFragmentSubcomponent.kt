package com.fcossetta.githubrest.di

import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.fcossetta.githubrest.ui.main.MainFragment

@Subcomponent
interface MainFragmentSubcomponent : AndroidInjector<MainFragment?> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainFragment?>
}