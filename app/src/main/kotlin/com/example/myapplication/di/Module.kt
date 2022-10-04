package com.example.myapplication.di

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import org.koin.dsl.module


/**
 * Created by Thuan Tang on 04/10/2022.
 */
val ktorModule = module {
    single { HttpClient(OkHttp) }
}