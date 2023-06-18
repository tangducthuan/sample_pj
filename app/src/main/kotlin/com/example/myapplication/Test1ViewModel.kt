package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class Test1ViewModel : ViewModel() {

    var id = ""

    val data = MutableStateFlow("")

    override fun onCleared() {
        super.onCleared()
        Log.e("Test1ViewModel", "onCleared: $id")
    }

}