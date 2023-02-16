package com.vnvj0033.bookplus.ui.subscript

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.component.GenreToggleList
import com.vnvj0033.bookplus.ui.component.PlatformSelectionList
import com.vnvj0033.bookplus.ui.component.state.PlatformsState

@Composable
fun SubscriptCompose() {

    
}

@Composable
private fun SubscriptCompose(name: String) {


    Column(Modifier.fillMaxHeight()) {
        PlatformSelectionList(
            state = PlatformsState()) { platform ->

        }

        GenreToggleList(options = listOf("abc", "bdds"))

    }

}

@Composable
@Preview
private fun Preview() {
    AppTheme {
        SubscriptCompose("")
    }
}