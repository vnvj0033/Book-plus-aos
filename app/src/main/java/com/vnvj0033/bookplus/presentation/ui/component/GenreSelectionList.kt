package com.vnvj0033.bookplus.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnvj0033.bookplus.presentation.ui.AppTheme
import com.vnvj0033.bookplus.presentation.ui.state.GenreSelectionListState

/**
 * 클릭시 장르만 변경, 이벤트는 호이스팅
 * */
@Composable
fun GenreSelectionList(
    state: GenreSelectionListState = GenreSelectionListState(),
    click: (String) -> Unit = {}
) {

    val options = listOf(
        "전체",
        "문학 작품",
        "국내 소설",
        "컴퓨터/IT",
        "취미/생활",
    )

    state.options.addAll(options)

    LazyRow(modifier = Modifier.padding(top = 8.dp)) {
        items(state.options) { text ->
            val isSelected = state.selectGenre == text

            GenreSelection(
                text = text,
                isSelected = isSelected
            ) { selectGenre ->
                state.selectGenre = selectGenre
                click.invoke(selectGenre)
            }
        }
    }
}

@Composable
private fun GenreSelection(
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
        GenreSelection("컴퓨터/IT", true)
    }
}

@Preview
@Composable
private fun PreviewGenreSelection() {
    AppTheme {
        GenreSelectionList()
    }
}