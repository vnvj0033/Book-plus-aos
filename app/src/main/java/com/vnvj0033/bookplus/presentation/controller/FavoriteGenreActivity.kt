package com.vnvj0033.bookplus.presentation.controller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vnvj0033.bookplus.presentation.ui.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteGenreActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                FavoriteGenreUI()
            }
        }
    }

    @Composable
    private fun FavoriteGenreUI() {

    }

    @Preview
    @Composable
    private fun Preview() {
        AppTheme {
            FavoriteGenreUI()
        }
    }
}