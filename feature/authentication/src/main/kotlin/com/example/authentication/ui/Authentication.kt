package com.example.authentication.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.data.account.TestDataClass

@Composable
fun AuthenticationScreen() {
    val test = TestDataClass()
    Text(text = test.msg)
}