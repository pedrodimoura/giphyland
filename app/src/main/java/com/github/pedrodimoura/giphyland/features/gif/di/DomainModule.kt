package com.github.pedrodimoura.giphyland.features.gif.di

import com.github.pedrodimoura.giphyland.features.gif.domain.repository.GifRepository
import com.github.pedrodimoura.giphyland.features.gif.domain.uc.FetchTrending
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun providesFetchTrendingUseCase(
        gifRepository: GifRepository
    ) = FetchTrending(gifRepository)

}