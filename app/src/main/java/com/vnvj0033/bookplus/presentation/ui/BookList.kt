package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.foundation.Image
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
import com.vnvj0033.bookplus.R
import com.vnvj0033.bookplus.domain.model.MainBook

@Composable
fun BookList() {

    LazyColumn(
        modifier = Modifier
            .padding(top = 8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(books) { book ->
            Book(book)
        }
    }
}

@Composable
fun Book(book: MainBook) {

    val maxHeight = 112.dp

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .sizeIn(maxHeight = maxHeight),
        shape = MaterialTheme.shapes.small
    ) {
        Row {
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


val books = listOf(
    MainBook("imagerUrl", "title", "writer", "summery"),
    MainBook("imagerUrl", "title", "writer", "summery"),
    MainBook("imagerUrl", "title", "writer", "summery"),
    MainBook("imagerUrl", "title", "writer", "summery"),
    MainBook("imagerUrl", "title", "writer", "summery"),
    MainBook("imagerUrl", "title", "writer", "summery")
)

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
        Book(books[0])
    }
}