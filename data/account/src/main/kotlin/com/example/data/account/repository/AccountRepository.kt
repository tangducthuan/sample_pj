package com.example.data.account.repository

import com.example.core.APIResponse
import com.example.data.account.model.AccountInfoResponse


/**
 * Created by Thuan Tang on 04/10/2022.
 */
interface AccountRepository {
    suspend fun getAccountInfo(): APIResponse<AccountInfoResponse>
}