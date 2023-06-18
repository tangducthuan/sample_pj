package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.android.getKoin
import org.koin.androidx.scope.ScopeActivity
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module

class Test1Activity : ScopeActivity() {

    var id = ""

    val t1module = module {
        this@Test1Activity.id = System.currentTimeMillis().toString()
        scope(named(this@Test1Activity.id)) {

            scoped { Test1ViewModel() }
        }
    }

    lateinit var viewModel: Test1ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(t1module)
        val session = getKoin().createScope("Test1Activity$id", named(id))
        scope?.linkTo(session)
        viewModel = get()
        setContentView(R.layout.activity_test1)

        findViewById<Button>(R.id.btn).setOnClickListener {
            startActivity(Intent(this, Test2Activity::class.java).apply {
                putExtra("id", id)
            })
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.data.collectLatest {
                    findViewById<TextView>(R.id.idText).text = it
                }
            }
        }

        lifecycleScope.launch { viewModel.data.emit("Test 1: $id") }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope?.close()
        unloadKoinModules(t1module)
    }
}