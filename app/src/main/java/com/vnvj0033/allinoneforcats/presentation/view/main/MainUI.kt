package com.vnvj0033.allinoneforcats.presentation.view.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vnvj0033.allinoneforcats.data.entry.Cat


@Composable
fun MainUI(state: MainState) {
    Column {
        Text(text = "선택 너의 고양이")
        CatGrid(state = state)
    }

}

@Composable
private fun CatGrid(state: MainState) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {


        items(state.items) { cat ->
            CatItem(cat) {
                state.click.value.invoke(cat)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatItem(cat: Cat, click: ()-> Unit) {
    Surface(onClick = click) {
        AsyncImage(
            model = cat.url,
            contentDescription = "this image is cat item",
        )
    }
}

class MainState {
    val items = mutableStateListOf<Cat>()
    val click = mutableStateOf({_:Cat -> })
}
