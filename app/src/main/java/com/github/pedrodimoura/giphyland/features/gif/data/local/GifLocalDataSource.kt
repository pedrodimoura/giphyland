package com.github.pedrodimoura.giphyland.features.gif.data.local

import com.github.pedrodimoura.giphyland.features.gif.data.local.model.GifLocalModel

interface GifLocalDataSource {
    suspend fun getAll(): List<GifLocalModel>
    suspend fun save(gifs: List<GifLocalModel>)
}