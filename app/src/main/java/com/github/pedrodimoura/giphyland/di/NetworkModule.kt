package com.github.pedrodimoura.giphyland.di

import android.util.Log
import com.github.pedrodimoura.giphyland.BuildConfig
import com.github.pedrodimoura.networking.HttpClient
import com.github.pedrodimoura.networking.RetrofitClientImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiKeyInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @ApiKeyInterceptor
    @Provides
    fun provideApiKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()

            val newUrl = request.url.newBuilder()
                .addQueryParameter(BuildConfig.API_KEY_HEADER, BuildConfig.API_KEY).build()

            val newRequest = request.newBuilder().url(newUrl).build()

            chain.proceed(newRequest)
        }
    }

    @Provides
    fun provideOkHttpClient(
        @ApiKeyInterceptor apiKeyInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(HttpLoggingInterceptor { Log.i("OK_HTTP_LOGGIN", it) }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @ExperimentalSerializationApi
    @Provides
    fun provideRetrofitHttpClient(okHttpClient: OkHttpClient): HttpClient =
        RetrofitClientImpl(BuildConfig.BASE_URL, okHttpClient)

}