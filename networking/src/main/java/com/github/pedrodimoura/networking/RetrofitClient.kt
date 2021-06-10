package com.github.pedrodimoura.networking

interface RetrofitClient : HttpClient {
    fun <T> create(c: Class<T>): T
}
