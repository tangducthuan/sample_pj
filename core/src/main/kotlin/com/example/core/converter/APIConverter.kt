package com.example.core.converter

import com.example.core.APIResponse
import com.example.core.Result


/**
 * Created by Thuan Tang on 04/10/2022.
 */
fun APIResponse.Error.toError(): Result.Error {
    return Result.Error(Exception(message))
}

fun <I, O> APIResponse<I>.toResult(map: (r: I?) -> O): Result<O> {
    return when (val response = this) {
        is APIResponse.Success -> Result.Success(map(response.data))
        else -> (response as APIResponse.Error).toError()
    }
}