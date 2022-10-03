package com.example.authentication

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.example.authentication.ui.AuthenticationScreen
import com.example.myapplication.fragment.ComposeFragment


/**
 * Created by Thuan Tang on 03/10/2022.
 */
class AuthenticationFragment : ComposeFragment() {

    @Composable
    override fun SetContent() {
        Column {
            TextButton(onClick = { Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show() }) {
                Text(text = "Click me")
            }
            AuthenticationScreen()
        }
    }
}