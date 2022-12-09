package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavoriteGenreCompose() {
    Column {
        BookList()
    }
}

@Composable
@Preview
private fun Preview() {
    AppTheme {
        FavoriteGenreCompose()
    }
}

/**
 *  Column {
 *      Filter()
 *      BookList { FavoriteBook ->
 *          FavoriteBookItem(FavoriteBook)
 *      }
 * }
 *
 * */