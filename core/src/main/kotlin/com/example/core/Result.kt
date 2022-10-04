package com.example.core


/**
 * Created by Thuan Tang on 04/10/2022.
 */
sealed class Result<out R> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val ex: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}
