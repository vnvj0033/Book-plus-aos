package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GenreSelectionList() {

    val options = listOf(
        "Option 1",
        "Option 2",
        "Option 3",
        "Option 4",
    )
    var selectedOption by remember {
        mutableStateOf("")
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }

    Row {
        options.forEach { text ->
            Text(
                text = text,
                color = Color.White,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onSelectionChange(text) }
                    .background(
                        if (text == selectedOption) {
                            Color.Magenta
                        } else {
                            Color.LightGray
                        }
                    )
                    .padding(
                        vertical = 12.dp,
                        horizontal = 16.dp,
                    )
            )

        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme {
        GenreSelectionList()
    }
}