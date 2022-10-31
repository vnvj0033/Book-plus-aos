package com.vnvj0033.allinoneforcats.presentation.view.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.vnvj0033.allinoneforcats.data.entry.Cat

import com.vnvj0033.allinoneforcats.presentation.presenter.MainViewModel
import com.vnvj0033.allinoneforcats.presentation.view.detail.CatDetailActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val mainState = MainState()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        setContent {
            MainUI(mainState)
        }

        viewModel.cats.observe(this) {
            mainState.items.addAll(it)
        }

        mainState.click.value = {cat: Cat ->
            val intent = Intent(this, CatDetailActivity::class.java).apply {
                putExtra("cat", cat)
            }
            startActivity(intent)
        }

        lifecycleScope.launch() {
            viewModel.loadCatList()
        }

    }
}