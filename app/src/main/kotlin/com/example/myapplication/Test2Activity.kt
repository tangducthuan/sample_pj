package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.android.getKoin
import org.koin.androidx.scope.ScopeActivity

class Test2Activity : ScopeActivity() {

    var id = ""
    lateinit var viewModel: Test1ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = intent.getStringExtra("id") ?: ""
        val session = getKoin().getScope("Test1Activity$id")
        scope?.linkTo(session)
        viewModel = get()
        setContentView(R.layout.activity_test2)

        lifecycleScope.launch {
            delay(7_000)
            viewModel.data.emit("Test 2: $id")
        }

        findViewById<Button>(R.id.btn).setOnClickListener {
            startActivity(Intent(this, Test1Activity::class.java))
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.data.collect {
                    findViewById<TextView>(R.id.idText).text = it
                }
            }
        }
    }
}