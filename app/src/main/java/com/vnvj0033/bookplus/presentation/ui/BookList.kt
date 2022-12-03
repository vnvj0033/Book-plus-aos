package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnvj0033.bookplus.R
import com.vnvj0033.bookplus.domain.model.MainBook

@Composable
fun BookList() {
    val books = listOf(
        MainBook("test1", "url"),
        MainBook("test2", "url"),
        MainBook("test3", "url")
    )

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(120.dp)
    ) {
        items(books) { book ->
            Book(book)
        }
    }
}

@Composable
fun Book(book: MainBook) {

    Surface(
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_blank_profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp))
            Text(
                text = book.title,
                modifier = Modifier.padding(horizontal = 16.dp))
        }
    }

}

@Composable
@Preview
private fun PreviewBookList() {
    AppTheme {
        BookList()
    }
}

@Composable
@Preview
private fun PreviewBook() {
    AppTheme {
        Book(MainBook("test1", "url"))
    }
}