package com.vnvj0033.bookplus.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vnvj0033.bookplus.data.model.MainBook


@Composable
fun BookCover(book: MainBook) {
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