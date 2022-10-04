package com.example.account.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.account.usecase.GetAccountUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch


/**
 * Created by Thuan Tang on 04/10/2022.
 */
class AccountViewModel(private val useCase: GetAccountUseCase): ViewModel() {

    fun test() {
        viewModelScope.launch {
            useCase("A").collectLatest {
                Log.e("AccountViewModel", it.toString())
            }
        }
    }
}