package com.vnvj0033.bookplus.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnvj0033.bookplus.data.model.Platform

/**
 * 클릭시 장르만 변경, 이벤트는 호이스팅
 * */
@Composable
fun GenreSelectionList(
    options: List<Platform.Genre>,
    click: (Platform.Genre) -> Unit = {}
) {
    if (options.isEmpty()) {
        return
    }

    val scrollState = rememberLazyListState()
    var selectedGenre: Platform.Genre by remember { mutableStateOf(options[0]) }

    LaunchedEffect(options) {
        selectedGenre = options[0]
        scrollState.scrollToItem(0)
    }

    LazyRow(
        modifier = Modifier.padding(top = 8.dp),
        state = scrollState
    ) {
        items(options) { genre ->
            val isSelected = selectedGenre == genre

            GenreSelection(
                genre = genre,
                isSelected = isSelected
            ) { selectGenre ->
                selectedGenre = selectGenre
                click.invoke(selectGenre)
            }
        }
    }
}

@Composable
private fun GenreSelection(
    genre: Platform.Genre,
    isSelected: Boolean = false,
    click: (Platform.Genre) -> Unit = {}
) {

    val background = if (isSelected) {
        Color(145, 208, 187)
    } else {
        Color.LightGray
    }

    Box(modifier = Modifier.padding(4.dp)) {
        Text(
            text = genre.name(),
            color = Color.White,
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .clickable { click.invoke(genre) }
                .background(background)
                .padding(
                    vertical = 12.dp,
                    horizontal = 16.dp,
                )
        )
    }
}
private object compoterAndIT : Platform.Genre {
    override fun name(): String = "컴퓨터/IT"
}
private object abc : Platform.Genre {
    override fun name(): String = "123"
}
private object bcd : Platform.Genre {
    override fun name(): String = "456"
}

@Preview
@Composable
private fun PreviewGenreSelectionList() {

    GenreSelection(compoterAndIT, true)

}

@Preview
@Composable
private fun PreviewGenreSelection() {
    val options = listOf(compoterAndIT, abc, bcd)

    GenreSelectionList(options)

}