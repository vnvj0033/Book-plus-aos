package com.vnvj0033.bookplus.ui.bookdetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vnvj0033.bookplus.R
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.ui.AppTheme


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
private fun BookCover(book: MainBook) {
    Row(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier.width(128.dp),
            placeholder = painterResource(R.drawable.ic_blank_profile),
            model = ImageRequest.Builder(LocalContext.current)
                .data(book.imgUrl)
                .placeholder(R.drawable.ic_blank_profile)
                .build(),
            contentDescription = null
        )
        
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TableText(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                key = "title",
                value = book.title)
            TableText(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                key = "writer",
                value = book.writer)
            TableText(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                key = "summery",
                value = book.summery)
        }
    }
}

@Composable
private fun TableText(modifier: Modifier, key: String, value: String) {
    Row(
        modifier = modifier,
        horizontalArrangement = SpaceBetween
    ) {
        Text(text = key)
        Text(text = value)
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