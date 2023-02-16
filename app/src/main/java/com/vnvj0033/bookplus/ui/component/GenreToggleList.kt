package com.vnvj0033.bookplus.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnvj0033.bookplus.ui.AppTheme

@Composable
fun GenreToggleList(
    options: List<String>,
    toggle: (List<String>) -> Unit = {}
) {
    FlowLayout {
        for (option in options) {
            GenreToggleList(
                text = option,
                isSelected = true
            ) { selectGenre ->
                toggle.invoke(listOf())
            }
        }
    }
}

@Composable
private fun FlowLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
){
    val measurePolicy = MeasurePolicy{ measurables,constraints ->
        layout(constraints.maxWidth,constraints.maxHeight){
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }
            var yPos = 0
            var xPos = 0
            var maxY = 0
            placeables.forEach { placeable ->
                if (xPos + placeable.width >
                    constraints.maxWidth
                ) {
                    xPos = 0
                    yPos += maxY
                    maxY = 0
                }
                placeable.placeRelative(
                    x = xPos,
                    y = yPos
                )
                xPos += placeable.width
                if (maxY < placeable.height) {
                    maxY = placeable.height
                }
            }
        }
    }
    Layout(measurePolicy = measurePolicy,
        content = content,
        modifier = modifier )
}

@Composable
private fun GenreToggleList(
    text: String,
    isSelected: Boolean = false,
    click: (String) -> Unit = {}
) {

    val background = if (isSelected) {
        Color(145, 208, 187)
    } else {
        Color.LightGray
    }

    Box(modifier = Modifier.padding(4.dp)) {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .clickable { click.invoke(text) }
                .background(background)
                .padding(
                    vertical = 12.dp,
                    horizontal = 16.dp,
                )
        )
    }
}

@Preview
@Composable
private fun PreviewGenreSelectionList() {
    AppTheme {
        GenreToggleList("컴퓨터/IT", true)
    }
}

@Preview
@Composable
private fun PreviewGenreSelection() {
    val options = listOf("12345", "234", "2345", "45", "12213345", "234", "2345", "45", "12345", "234", "2345", "45")
    AppTheme {
        GenreToggleList(options)
    }
}