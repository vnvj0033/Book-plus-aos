package com.vnvj0033.bookplus.feature.subscript

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

    val options = viewModel.genres.collectAsState(emptyList())
    val selectedSet = viewModel.userGenres.collectAsState(emptyList())
    val platform = viewModel.platform.collectAsState()

    Column(Modifier.fillMaxHeight()) {
        PlatformSelectionList(platform = platform.value) { platform ->
            viewModel.updateOptions(platform)
        }

        GenreToggleList(
            options = options.value,
            selected = selectedSet.value.toSet()
        ) { set ->
            viewModel.updateGenre(set)
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