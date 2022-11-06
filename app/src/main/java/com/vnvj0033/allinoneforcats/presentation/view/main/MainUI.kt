package com.vnvj0033.allinoneforcats.presentation.view.main

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import coil.compose.AsyncImage
import com.vnvj0033.allinoneforcats.data.entry.CatEntry
import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.data.repository.FakeCatRepo
import com.vnvj0033.allinoneforcats.domain.model.DetailCat
import com.vnvj0033.allinoneforcats.presentation.presenter.MainViewModel
import com.vnvj0033.allinoneforcats.presentation.presenter.MainViewModelFactory
import com.vnvj0033.allinoneforcats.presentation.view.detail.DetailActivity
import com.vnvj0033.allinoneforcats.presentation.view.theme.AppTheme

@Composable
fun MainUI(catRepository: CatRepository) {
    val viewModelStoreOwner = LocalViewModelStoreOwner.current
    val context = LocalContext.current

    val factory = MainViewModelFactory(catRepository)
    val viewModel = ViewModelProvider(viewModelStoreOwner!!, factory)[MainViewModel::class.java]

    viewModel.state.click = { cat: DetailCat ->
        val intent = Intent(context, DetailActivity::class.java).apply {
            putExtra("cat", cat)
        }
        context.startActivity(intent)
    }

    MainUI(viewModel.state)

    viewModel.loadCatList()
}

@Composable
private fun MainUI(state: MainState) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "선택 너의 고양이",
            modifier = Modifier
                .padding(16.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)

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
                state.click.invoke(cat)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatItem(cat: DetailCat, click: ()-> Unit) {
    Surface(onClick = click) {
        AsyncImage(
            model = cat.url,
            contentDescription = "this image is cat item"
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
    AppTheme {
        MainUI(FakeCatRepo())
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true)
@Composable
fun PreviewDark() {
    AppTheme {
        MainUI(FakeCatRepo())
    }
}
