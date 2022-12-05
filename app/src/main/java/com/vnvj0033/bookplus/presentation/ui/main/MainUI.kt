package com.vnvj0033.bookplus.presentation.ui.main

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vnvj0033.bookplus.presentation.ui.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUI() {

    val platformState = null
    val genreState = null
    val booksState = null

    val platformClick = {

    }

    val genreClick = {

    }

    val bookClick = {

    }

    val navigateClick = {

    }

    Scaffold(bottomBar =  {BottomNavigation()}) {
        Column(modifier = Modifier.padding(it)) {
            PlatformSelectionList()
            GenreSelectionList()
            BookList()
        }
    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        MainUI()
    }
}