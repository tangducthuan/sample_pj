package com.example.data.account.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Created by Thuan Tang on 04/10/2022.
 */
@Serializable
data class AccountInfoResponse(
    @SerialName("id") val id: String? = null,
    @SerialName("email") val email: String? = null
)