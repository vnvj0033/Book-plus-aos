package com.vnvj0033.bookplus.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GenreToggleList(
    options: List<String>,
    toggle: (List<String>) -> Unit = {},
    selectedList: List<String> = emptyList()
) {

    val list = selectedList.toMutableStateList()

    FlowLayout {
        for (option in options) {
            val isSelected = selectedList.contains(option)

            ToggleItem(
                text = option,
                isSelected = isSelected
            ) { selectedGenre ->
                if (isSelected) {
                    list.remove(selectedGenre)
                } else {
                    list.add(selectedGenre)
                }
                toggle.invoke(list)
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
private fun ToggleItem(
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
    ToggleItem("컴퓨터/IT", true)

}

@Preview
@Composable
private fun PreviewGenreSelection() {
    val options = listOf("12345", "234", "2345", "45", "12213345", "234", "2345", "45", "12345", "234", "2345", "45")

    GenreToggleList(options)

}