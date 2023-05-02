package com.vnvj0033.bookplus.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vnvj0033.bookplus.data.model.MainBook

@Composable
fun BookList(
    books: List<MainBook> = listOf(),
    click: (MainBook) -> Unit = {}
) {

    LazyColumn(
        modifier = Modifier.padding(top = 8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(books) { book ->
            Book(book, click)
        }
    }
}

@Composable
fun Book(
    book: MainBook,
    click: (MainBook) -> Unit = {}
) {

    val maxHeight = 112.dp

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .sizeIn(maxHeight = maxHeight),
        shape = MaterialTheme.shapes.small
    ) {
        Row(Modifier.clickable { click.invoke(book) }) {
            Image(
                modifier = Modifier.size(112.dp),
                painter = painterResource(R.drawable.ic_blank_profile),
                contentDescription = null,
                contentScale = ContentScale.Crop)
            Column {
                Row {
                    Text(
                        text = book.title,
                        modifier = Modifier.padding(horizontal = 16.dp))
                    Text(text = book.writer)
                }
                Text(text = book.summery,
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 8.dp),
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
@Preview
private fun PreviewBookList() {
    val list = listOf(
        MainBook("", "title", "writer", "summery"),
        MainBook("", "title", "writer", "summery"),
        MainBook("", "title", "writer", "summery"),
        MainBook("", "title", "writer", "summery"),
        MainBook("", "title", "writer", "summery")
    )
    BookList(list)
}

@Composable
@Preview
private fun PreviewBook() {
    Book(MainBook("", "", "", ""))
}