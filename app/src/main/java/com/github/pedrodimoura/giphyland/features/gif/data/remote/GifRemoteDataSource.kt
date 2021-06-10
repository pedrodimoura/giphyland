package com.github.pedrodimoura.giphyland.features.gif.data.remote

import com.github.pedrodimoura.giphyland.features.gif.data.remote.model.GifRemoteModel

interface GifRemoteDataSource {
    suspend fun fetchTrending(): List<GifRemoteModel>
}
