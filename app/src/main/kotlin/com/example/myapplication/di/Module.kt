package com.example.myapplication.di

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


/**
 * Created by Thuan Tang on 04/10/2022.
 */
val ktorModule = module {
    single { HttpClient(OkHttp) }
}

val dispatcherModule = module {
    single { Dispatchers.IO }
}