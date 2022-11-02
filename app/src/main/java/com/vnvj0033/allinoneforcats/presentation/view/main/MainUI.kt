package com.vnvj0033.allinoneforcats.presentation.view.main

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.vnvj0033.allinoneforcats.data.entry.Cat
import com.vnvj0033.allinoneforcats.presentation.presenter.MainState
import com.vnvj0033.allinoneforcats.presentation.presenter.MainViewModel
import com.vnvj0033.allinoneforcats.presentation.view.detail.CatDetailActivity

@Composable
fun MainUI() {



    MainUI(viewModel())
}

@Composable
private fun MainUI(viewModel: MainViewModel) {

    val context = LocalContext.current

    viewModel.state.click.value = {cat: Cat ->
        val intent = Intent(context, CatDetailActivity::class.java).apply {
            putExtra("cat", cat)
        }
        context.startActivity(intent)
    }

    viewModel.loadCatList()

    Column {
        Text(text = "선택 너의 고양이")
        CatGrid(state = viewModel.state)
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
