package com.example.core.usecase

import com.example.core.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


/**
 * Created by Thuan Tang on 04/10/2022.
 */
abstract class UseCase<in P, R>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(p: P): Result<R> {
        return try {
            withContext(dispatcher) {
                Result.Success(execute(p))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    protected abstract suspend fun execute(p: P): R
}
