package com.example.myapplication.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.myapplication.MainActivity


/**
 * Created by Thuan Tang on 03/10/2022.
 */
abstract class ComposeFragment : Fragment() {

    companion object {
        private const val RESULT = "result"
    }

    private lateinit var _view: ComposeView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _view = ComposeView(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _view.setContent { SetContent() }
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        resultLiveData?.observe(viewLifecycleOwner) {
            it ?: return@observe
            onResult(it.first, it.second)
        }
    }

    @Composable
    abstract fun SetContent()

    protected open fun onResult(path: String, data: Bundle) {}

    protected val navController = (activity as? MainActivity)?.navController

    protected open fun navController(block: NavController.() -> Unit) {
        navController?.block()
    }

    protected val resultLiveData: LiveData<Pair<String, Bundle>>?
        get() = navController?.currentBackStackEntry?.savedStateHandle?.getLiveData<Pair<String, Bundle>>(RESULT)

    protected fun setResult(path: String, data: Bundle) {
        navController?.previousBackStackEntry?.savedStateHandle?.getLiveData<Pair<String, Bundle>>(RESULT)
            ?.postValue(path to data)
    }

}