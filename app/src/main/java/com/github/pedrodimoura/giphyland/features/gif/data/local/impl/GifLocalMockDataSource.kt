package com.github.pedrodimoura.giphyland.features.gif.data.local.impl

import com.github.pedrodimoura.giphyland.features.gif.data.local.GifLocalDataSource
import com.github.pedrodimoura.giphyland.features.gif.data.local.model.GifLocalModel
import javax.inject.Inject

class GifLocalMockDataSource @Inject constructor() : GifLocalDataSource {
    override suspend fun getAll(): List<GifLocalModel> {
        return emptyList()
    }

    override suspend fun save(gifs: List<GifLocalModel>) {}
}