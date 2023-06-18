package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel

class Test2ViewModel : ViewModel() {

    var id = ""

    override fun onCleared() {
        super.onCleared()
        Log.e("Test2ViewModel", "onCleared: $id")
    }

}