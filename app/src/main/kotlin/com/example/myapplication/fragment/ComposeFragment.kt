package com.example.myapplication.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment


/**
 * Created by Thuan Tang on 03/10/2022.
 */
abstract class ComposeFragment : Fragment() {
    private lateinit var _view: ComposeView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _view = ComposeView(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _view.setContent { SetContent() }
        return _view
    }

    @Composable
    abstract fun SetContent()

}