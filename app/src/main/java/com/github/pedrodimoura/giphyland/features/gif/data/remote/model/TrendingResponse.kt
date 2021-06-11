package com.github.pedrodimoura.giphyland.features.gif.data.remote.model

import com.google.gson.annotations.SerializedName

data class TrendingResponse(
    @SerializedName("data")
    val gifs: List<GifRemoteModel>,
    val pagination: PaginationResponse,
    val meta: MetaResponse,
)