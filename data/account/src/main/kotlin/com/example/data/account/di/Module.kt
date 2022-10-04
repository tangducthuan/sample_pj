package com.example.data.account.di

import com.example.data.account.repository.AccountRepository
import com.example.data.account.repository_imp.AccountRepositoryImp
import com.example.data.account.usecase.GetAccountUseCase
import com.example.data.account.usecase.TestConverter
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


/**
 * Created by Thuan Tang on 04/10/2022.
 */
val dataAccountRepoModule = module {
    single<AccountRepository> { AccountRepositoryImp(get()) }
}

val dataAccountUseCaseModule = module {
    single { GetAccountUseCase(get(), TestConverter(), Dispatchers.IO) }
}