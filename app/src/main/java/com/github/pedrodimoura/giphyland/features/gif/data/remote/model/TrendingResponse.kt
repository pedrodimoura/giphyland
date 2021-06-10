package com.github.pedrodimoura.giphyland.features.gif.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingResponse(
    @SerialName("data")
    val gifs: List<GifRemoteModel>,
    val pagination: PaginationResponse,
    val meta: MetaResponse,
)