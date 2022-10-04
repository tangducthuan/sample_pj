package com.example.account.di

import com.example.account.viewmodel.AccountViewModel
import com.example.data.account.di.dataAccountRepoModule
import com.example.data.account.di.dataAccountUseCaseModule
import com.example.myapplication.di.ktorModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


/**
 * Created by Thuan Tang on 04/10/2022.
 */
val injectModule by lazy {
    loadKoinModules(listOf(
        ktorModule,
        dataAccountRepoModule,
        dataAccountUseCaseModule,
        featureAccountModule
    ))
}

val featureAccountModule = module {
    viewModel { AccountViewModel(get()) }
}