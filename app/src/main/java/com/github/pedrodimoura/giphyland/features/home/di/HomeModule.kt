package com.github.pedrodimoura.giphyland.features.home.di

import com.github.pedrodimoura.giphyland.features.gif.data.local.GifLocalDataSource
import com.github.pedrodimoura.giphyland.features.gif.data.local.impl.GifLocalMockDataSource
import com.github.pedrodimoura.giphyland.features.gif.data.remote.GifRemoteDataSource
import com.github.pedrodimoura.giphyland.features.gif.data.remote.impl.GifRemoteMockDataSource
import com.github.pedrodimoura.giphyland.features.gif.data.repository.GifRepositoryImpl
import com.github.pedrodimoura.giphyland.features.gif.domain.repository.GifRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ActivityComponent::class)
object HomeModule {

    @Module
    @InstallIn(ViewModelComponent::class)
    abstract class DataModule {
        @Binds
        abstract fun providesGifRepository(
            gifRepositoryImpl: GifRepositoryImpl
        ): GifRepository

        @Binds
        abstract fun bindsGifRemoteDataSource(
            gifRemoteMockDataSource: GifRemoteMockDataSource
        ): GifRemoteDataSource

        @Binds
        abstract fun bindsGifLocalDataSource(
            gifLocalMockDataSource: GifLocalMockDataSource
        ): GifLocalDataSource
    }

}
