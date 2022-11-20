package com.vnvj0033.allinoneforcats.presentation.view.detail

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import coil.compose.AsyncImage
import com.vnvj0033.allinoneforcats.domain.model.DetailCat
import com.vnvj0033.allinoneforcats.presentation.presenter.DetailViewModel

@Composable
fun DetailUI(viewModel: DetailViewModel) {
    val state = viewModel.state
    val cat = state.cat

    Row {
        AsyncImage(model = cat.url, contentDescription = "this image is cat item" )
    }
}


class DetailState {
    var cat by mutableStateOf(DetailCat())
}