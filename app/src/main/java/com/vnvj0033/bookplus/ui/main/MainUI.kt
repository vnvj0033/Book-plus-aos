package com.vnvj0033.bookplus.ui.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.component.BottomNavigation
import com.vnvj0033.bookplus.ui.main.navigation.MainNavHost


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUI() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(navController) }
    ) { paddingValue ->

        MainNavHost(
            modifier = Modifier.padding(paddingValue),
            navController = navController
        )
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        MainUI()
    }
}