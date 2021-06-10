package com.github.pedrodimoura.giphyland.features.gif.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GifRemoteModel(
    val type: Type = Type.GIF,
    val id: String = "",
    val slug: String = "",
    val url: String = "",
    @SerialName("bitly_gif_url")
    val bitLyGifUrl: String = "",
    @SerialName("bitly_url")
    val bitLyUrl: String = "",
    @SerialName("embed_url")
    val embedUrl: String = "",
    val username: String = "",
    val source: String = "",
    val rating: Rating,
    @SerialName("source_tld")
    val sourceTld: String = "",
    @SerialName("source_post_url")
    val sourceUrl: String = "",
    @SerialName("update_datetime")
    val updateDateTime: String = "",
    @SerialName("create_datetime")
    val createDateTime: String = "",
    @SerialName("import_datetime")
    val importDateTime: String = "",
    @SerialName("trending_date_time")
    val trendingDateTime: String = "",
    val title: String = "",
    val images: ImagesRemoteModel,
) {
    @Serializable
    enum class Type(name: String) {
        @SerialName("gif")
        GIF("gif"),
    }

    @Serializable
    enum class Rating(name: String) {
        @SerialName("y")
        Y("y"),

        @SerialName("g")
        G("g"),

        @SerialName("pg")
        PG("pg"),

        @SerialName("pg-13")
        PG13("pg-13"),

        @SerialName("r")
        R("r"),
    }
}