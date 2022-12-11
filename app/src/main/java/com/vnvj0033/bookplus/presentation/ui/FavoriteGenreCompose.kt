package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteGenreCompose() {
    Column {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "SUBSCRIPT")
        Divider()
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