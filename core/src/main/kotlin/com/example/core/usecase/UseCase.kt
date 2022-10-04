package com.example.core.usecase

import com.example.core.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*


/**
 * Created by Thuan Tang on 04/10/2022.
 */
abstract class UseCase<in P, R>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(p: P) = flow {
        emit(execute(p))
    }
    .onStart { emit(Result.Loading) }
    .catch { emit(Result.Error(Exception(it))) }
    .flowOn(dispatcher)

    protected abstract suspend fun execute(p: P): Result<R>
}
