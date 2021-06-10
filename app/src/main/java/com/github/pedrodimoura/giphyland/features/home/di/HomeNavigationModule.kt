package com.github.pedrodimoura.giphyland.features.home.di

import com.github.pedrodimoura.giphyland.features.home.navigation.HomeNavigationImpl
import com.github.pedrodimoura.navigation.home.HomeNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeNavigationModule {

    @Binds
    abstract fun bindsHomeNavigation(homeNavigationImpl: HomeNavigationImpl): HomeNavigation

}