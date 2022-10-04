package com.example.data.account.repository_imp

import com.example.core.APIResponse
import com.example.data.account.model.AccountInfoResponse
import com.example.data.account.repository.AccountRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*


/**
 * Created by Thuan Tang on 04/10/2022.
 */
class AccountRepositoryImp(private val client: HttpClient) : AccountRepository {
    override suspend fun getAccountInfo(): APIResponse<AccountInfoResponse> {
        return client.get("account/info").body()
    }
}