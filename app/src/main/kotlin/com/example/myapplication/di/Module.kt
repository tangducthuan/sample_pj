package com.example.myapplication.di

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

/**
 * Created by Thuan Tang on 04/10/2022.
 */
val ktorModule = module {
    single {
        HttpClient(OkHttp) {
            install(HttpRequestRetry) {
                maxRetries = 1
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 10_000L
                connectTimeoutMillis = 10_000L
            }
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "abc.com"
                }
                headers {
                    set("token", "token")
                    set("language", "en")
                }
            }
        }.apply {
            plugin(HttpSend).intercept { request ->
                val call = execute(request)



                call
                //TODO show log
            }
        }
    }
}

val dispatcherModule = module {
    single { Dispatchers.IO }
}
