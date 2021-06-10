package com.github.pedrodimoura.giphyland.features.gif.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationResponse(
    @SerialName("total_count")
    val totalCount: Int,
    val count: Int,
    val offset: Int,
)
