package com.vnvj0033.bookplus.presentation.controller

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vnvj0033.bookplus.presentation.ui.AppTheme
import com.vnvj0033.bookplus.presentation.ui.BottomNavigation
import com.vnvj0033.bookplus.presentation.ui.MainCompose
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                MainUI()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MainUI() {
        Scaffold(bottomBar = { BottomNavigation() }) {
            MainCompose(modifier = Modifier.padding(it))
        }
    }


    @Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
    @Composable
    private fun Preview() {
        AppTheme {
            MainUI()
        }
    }
}