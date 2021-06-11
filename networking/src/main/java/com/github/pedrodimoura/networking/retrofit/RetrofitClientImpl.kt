package com.github.pedrodimoura.networking.retrofit

import com.github.pedrodimoura.networking.RetrofitClient
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientImpl(
    private val baseUrl: String,
    private val okHttpClient: OkHttpClient,
) : RetrofitClient {

    private val contentType = "application/json".toMediaType()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()
                )
            )
            .build()
    }

    override fun <T> create(c: Class<T>): T = retrofit.create(c)

}