package com.vnvj0033.bookplus.presentation.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnvj0033.bookplus.R

@Composable
fun PlatformSelectionList() {
    val platforms = listOf("1", "2", "3")
    LazyRow(Modifier.fillMaxWidth()) {
        items(platforms) { title ->
            PlatformSelection(title)
        }

    }
}


@Composable
fun PlatformSelection(title: String) {
    val image = painterResource(R.drawable.ic_blank_cat)

    val maxSize = 88.dp

    val selectedColor = Color.Yellow

    Column(
        modifier = Modifier
            .background(selectedColor)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(maxSize)
                .clip(CircleShape)
        )
        Text(
            text = title,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .sizeIn(maxWidth = maxSize)
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewPlatformSelectionList() {
    AppTheme {
        PlatformSelectionList()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewPlatformSelection() {
    AppTheme {
        PlatformSelection("preview title")
    }
}