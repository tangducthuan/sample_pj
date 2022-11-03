package com.example.core.usecase

import com.example.core.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*


/**
 * Created by Thuan Tang on 04/10/2022.
 */
abstract class FlowUseCase<in P, R>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(p: P) = execute(p)
    .onStart { emit(Result.Loading) }
    .catch { emit(Result.Error(Exception(it))) }
    .flowOn(dispatcher)

    protected abstract suspend fun execute(p: P): Flow<Result<R>>
}
