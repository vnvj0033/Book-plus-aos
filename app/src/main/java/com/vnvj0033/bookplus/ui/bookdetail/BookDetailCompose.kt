package com.vnvj0033.bookplus.ui.bookdetail

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vnvj0033.bookplus.data.model.MainBook
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.BookCover


@Composable
fun BookDetailCompose(
    viewModel: BookDetailViewModel = hiltViewModel()
) {
    val book = viewModel.book.collectAsState()

    Row {
       BookCover(book.value)
    }
}


@Composable
@Preview(showSystemUi = true)
private fun PreviewOfBookCover() {
    AppTheme {
        BookCover(
            MainBook(
                "imageUrl",
                "title",
                "writer",
                "summery"
            )
        )
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme {
        BookDetailCompose()
    }
}