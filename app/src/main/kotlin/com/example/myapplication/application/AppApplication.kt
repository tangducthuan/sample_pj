package com.example.myapplication.application

import android.app.Application
import com.example.myapplication.di.ktorModule
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            ktorModule
        }
    }
}