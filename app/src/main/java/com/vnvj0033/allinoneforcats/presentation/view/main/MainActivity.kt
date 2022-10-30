package com.vnvj0033.allinoneforcats.presentation.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.vnvj0033.allinoneforcats.data.entry.Cat
import com.vnvj0033.allinoneforcats.presentation.presenter.MainPresenter

class MainActivity : ComponentActivity() {

    private val mainState = MainState()
    private val viewModel: MainPresenter by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        setContent {
            MainUI(mainState)
        }

        viewModel.loadCatList { cats: List<Cat>->
            mainState.items.addAll(cats)
        }

    }
}