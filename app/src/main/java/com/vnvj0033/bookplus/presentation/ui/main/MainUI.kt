package com.vnvj0033.bookplus.presentation.ui.main

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.vnvj0033.bookplus.presentation.ui.*

@Composable
fun MainUI() {

    Row {
        PlatformSelectionList()
        GenreSelectionList()
        BookList()
        BottomNavigation()
    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
    AppTheme {
        MainUI()
    }
}