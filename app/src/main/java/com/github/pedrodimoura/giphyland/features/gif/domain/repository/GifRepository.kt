package com.github.pedrodimoura.giphyland.features.gif.domain.repository

import com.github.pedrodimoura.giphyland.features.gif.domain.model.Gif

interface GifRepository {
    suspend fun fetchTrending(): List<Gif>
}
