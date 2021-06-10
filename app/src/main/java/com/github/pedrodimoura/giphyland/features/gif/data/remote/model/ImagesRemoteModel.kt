package com.github.pedrodimoura.giphyland.features.gif.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesRemoteModel(
    @SerialName("fixed_height")
    val fixedHeight: FixedHeightRemoteModel
)

@Serializable
data class FixedHeightRemoteModel(
    val url: String = ""
)
