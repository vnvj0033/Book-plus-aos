package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnvj0033.bookplus.presentation.ui.component.BookList

@Composable
fun FavoriteGenreCompose(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "SUBSCRIPT")
            Filter()
        }
        Divider()
        BookList()
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
