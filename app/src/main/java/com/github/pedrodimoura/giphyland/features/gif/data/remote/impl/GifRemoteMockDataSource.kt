package com.github.pedrodimoura.giphyland.features.gif.data.remote.impl

import com.github.pedrodimoura.giphyland.features.gif.data.remote.GifRemoteDataSource
import com.github.pedrodimoura.giphyland.features.gif.data.remote.model.GifRemoteModel
import com.github.pedrodimoura.giphyland.features.gif.data.remote.service.GiphyAPI
import com.github.pedrodimoura.networking.RetrofitClient
import javax.inject.Inject

class GifRemoteMockDataSource @Inject constructor(
    private val httpClient: RetrofitClient
) : GifRemoteDataSource {

    private val giphyAPI: GiphyAPI by lazy { httpClient.create(GiphyAPI::class.java) }

    override suspend fun fetchTrending(): List<GifRemoteModel> {
        return giphyAPI.getTrending().gifs
    }
}