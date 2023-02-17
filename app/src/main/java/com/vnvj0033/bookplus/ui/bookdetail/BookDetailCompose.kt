package com.vnvj0033.bookplus.ui.bookdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vnvj0033.bookplus.ui.AppTheme

@Composable
fun BookDetailCompose(
    viewModel: BookDetailViewModel = hiltViewModel()
) {
    val book = viewModel.book.collectAsState()


}

@Preview
@Composable
fun Preview() {
    AppTheme {
        BookDetailCompose()
    }
}