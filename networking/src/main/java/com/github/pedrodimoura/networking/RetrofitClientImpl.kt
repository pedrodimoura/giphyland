package com.github.pedrodimoura.networking

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@ExperimentalSerializationApi
class RetrofitClientImpl(
    private val baseUrl: String,
    private val okHttpClient: OkHttpClient,
) : RetrofitClient {

    private val contentType = "application/json".toMediaType()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(Json {
                isLenient = true
                ignoreUnknownKeys = true
                encodeDefaults = true
            }.asConverterFactory(contentType))
            .build()
    }

    override fun <T> create(c: Class<T>): T = retrofit.create(c)

}