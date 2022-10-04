package com.example.core


/**
 * Created by Thuan Tang on 04/10/2022.
 */
sealed class APIResponse<out T> {
    data class Success<T>(val data: T?) : APIResponse<T>()
    data class Error(val httpCode: Int, val message: String): APIResponse<Nothing>()
}