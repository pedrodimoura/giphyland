package com.github.pedrodimoura.giphyland.features.gif.data.remote.service

import com.github.pedrodimoura.giphyland.features.gif.data.remote.model.TrendingResponse
import retrofit2.http.GET

interface GiphyAPI {

    @GET("gifs/trending")
    suspend fun getTrending(): TrendingResponse

}