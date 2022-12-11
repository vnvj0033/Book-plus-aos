package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteGenreCompose() {
    Column {

        Row {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "SUBSCRIPT")

            Filter()
        }
        Divider()
        BookList()
    }
}
@Composable
private fun Filter() {

    DropdownMenu(
        expanded = true,
        onDismissRequest = { /*TODO*/ }
    ) {

        testdata.forEach {
            Text(text = it)
        }
    }
}

private val testdata = listOf(
    "it",
    "문학",
    "인문",
    "소설"
)

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