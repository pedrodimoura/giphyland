package com.github.pedrodimoura.giphyland.features.gif.data.remote.model

import com.google.gson.annotations.SerializedName

data class GifRemoteModel(
    val type: Type = Type.GIF,
    val id: String,
    val slug: String,
    val url: String,
    val bitLyGifUrl: String,
    val bitlyUrl: String,
    val embedUrl: String,
    val username: String,
    val source: String,
    val rating: Rating,
    val sourceTld: String,
    @SerializedName("source_post_url")
    val sourceUrl: String,
    val updateDatetime: String?,
    val createDatetime: String?,
    val importDatetime: String?,
    val trendingDatetime: String?,
    val title: String,
    val images: ImagesRemoteModel,
) {
    enum class Type(name: String) {
        @SerializedName("gif")
        GIF("gif"),
    }

    enum class Rating(name: String) {
        @SerializedName("y")
        Y("y"),

        @SerializedName("g")
        G("g"),

        @SerializedName("pg")
        PG("pg"),

        @SerializedName("pg-13")
        PG13("pg-13"),

        @SerializedName("r")
        R("r"),
    }
}