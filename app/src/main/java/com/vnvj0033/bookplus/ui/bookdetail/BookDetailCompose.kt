package com.vnvj0033.bookplus.ui.bookdetail

import androidx.compose.foundation.layout.*
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
import com.vnvj0033.bookplus.data.model.MainBook
import com.vnvj0033.bookplus.R
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
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TableText(
                key = "title",
                value = book.title)
            Spacer(modifier = Modifier.height(4.dp))
            TableText(
                key = "writer",
                value = book.writer)
            Spacer(modifier = Modifier.height(4.dp))
            TableText(
                key = "summery",
                value = book.summery)
        }
    }
}

@Composable
private fun TableText(
    modifier: Modifier = Modifier,
    key: String,
    value: String,
    weight: Float = 0.4f
) {

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = key,
        modifier = Modifier.weight(weight))
        Text(text = value,
            modifier = Modifier.weight(1 - weight))
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