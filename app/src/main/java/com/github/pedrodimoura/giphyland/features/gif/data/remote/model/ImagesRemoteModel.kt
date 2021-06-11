package com.github.pedrodimoura.giphyland.features.gif.data.remote.model

data class ImagesRemoteModel(
    val fixedHeight: FixedHeightRemoteModel
)

data class FixedHeightRemoteModel(
    val url: String
)
