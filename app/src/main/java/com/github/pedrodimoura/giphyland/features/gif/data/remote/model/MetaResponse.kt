package com.github.pedrodimoura.giphyland.features.gif.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetaResponse(
    val status: Int,
    val msg: String,
    @SerialName("response_id")
    val responseId: String,
)
