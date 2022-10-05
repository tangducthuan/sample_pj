package com.example.account

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.example.account.di.injectModule
import com.example.account.ui.AccountScreen
import com.example.account.viewmodel.AccountViewModel
import com.example.myapplication.fragment.ComposeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Created by Thuan Tang on 04/10/2022.
 */
class AccountFragment : ComposeFragment() {

    private val viewModel: AccountViewModel by viewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectModule
    }

    @Composable
    override fun SetContent() {
        viewModel.test()
        Column {
            TextButton(onClick = { Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show() }) {
                Text(text = "Click me")
            }
            AccountScreen()
        }
    }

    override fun onResult(path: String, data: Bundle) {

    }
}