package com.github.pedrodimoura.giphyland.features.gif.data.local.model

data class GifLocalModel(
    val type: GifLocalModel.Type = Type.GIF,
    val id: String,
    val slug: String,
    val url: String,
    val bitLyUrl: String,
    val embedUrl: String,
    val username: String,
    val source: String,
    val rating: Rating,
    val sourceTld: String,
    val sourceUrl: String,
    val updateDateTime: String,
    val createDateTime: String,
    val importDateTime: String,
    val trendingDateTime: String,
    val title: String,
    val imageUrl: String
) {

    enum class Type(name: String) {
        GIF("gif"),
    }

    enum class Rating(name: String) {
        Y("y"),
        G("g"),
        PG("pg"),
        PG13("pg-13"),
        R("r"),
    }

}
