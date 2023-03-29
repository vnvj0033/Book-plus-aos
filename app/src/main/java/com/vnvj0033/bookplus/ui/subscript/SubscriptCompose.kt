package com.vnvj0033.bookplus.ui.subscript

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.GenreToggleList
import com.vnvj0033.bookplus.ui.PlatformSelectionList

@Composable
fun SubscriptCompose(viewModel: SubscriptViewModel = hiltViewModel()) {

    val options = viewModel.options.collectAsState()
    val selectedSet = viewModel.selectedGenreState.collectAsState()

    Column(Modifier.fillMaxHeight()) {
        PlatformSelectionList { platform ->
            viewModel.updateOptions(platform)
        }

        GenreToggleList(
            options = options.value,
            selectedList = selectedSet.value
        ) { set ->
            viewModel.updateSelectedGenre(set)
        }
    }

}

@Composable
@Preview
private fun Preview() {
    AppTheme {
        SubscriptCompose()
    }
}