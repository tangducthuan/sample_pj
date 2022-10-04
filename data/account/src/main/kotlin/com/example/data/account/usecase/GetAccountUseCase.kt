package com.example.data.account.usecase

import com.example.core.Result
import com.example.core.converter.Converter
import com.example.core.converter.toResult
import com.example.core.usecase.UseCase
import com.example.data.account.model.AccountInfoResponse
import com.example.data.account.repository.AccountRepository
import kotlinx.coroutines.CoroutineDispatcher


/**
 * Created by Thuan Tang on 04/10/2022.
 */
class GetAccountUseCase(
    private val accountRepository: AccountRepository,
    private val converter: TestConverter,   //Optional, just use to split or reuse converter logic
    dispatcher: CoroutineDispatcher
) : UseCase<String, AccountInfoResponse>(dispatcher) {

    override suspend fun execute(p: String): Result<AccountInfoResponse> {
        return accountRepository.getAccountInfo().toResult(converter::map)
    }

}

class TestConverter : Converter<AccountInfoResponse?, AccountInfoResponse> {
    override fun map(input: AccountInfoResponse?): AccountInfoResponse {
        return input ?: AccountInfoResponse()
    }

}