package com.github.pedrodimoura.networking

interface HttpClient

interface RetrofitClient : HttpClient {
    fun <T> create(c: Class<T>): T
}