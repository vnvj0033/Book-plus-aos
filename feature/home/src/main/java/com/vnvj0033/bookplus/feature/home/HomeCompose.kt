package com.vnvj0033.bookplus.feature.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vnvj0033.bookplus.common.feature.BookDetailActivity
import com.vnvj0033.bookplus.data.model.MainBook
import com.vnvj0033.bookplus.data.model.Platform
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.BookList
import com.vnvj0033.bookplus.ui.GenreSelectionList
import com.vnvj0033.bookplus.ui.PlatformSelectionList

@Composable
fun HomeCompose(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val platforms = Platform.platforms()
    platforms.forEach {
        Log.d("testPlatform", it.name())
    }

    when(uiState) {
        is HomeUiState.Loading -> {
            Loading(viewModel::updateGenre)
        }
        is HomeUiState.Success -> {
            HomeScreen(
                state = (uiState as HomeUiState.Success).homeStateData,
                updateGenre = viewModel::updateGenre,
                updateBooks = viewModel::updateBooks
            )
        }
    }

    LaunchedEffect(true) {
        viewModel.updateGenre(Platform.KYOBO)
    }

}

@Composable
fun HomeScreen(
    state: HomeStateData,
    updateGenre: (Platform) -> Unit = {},
    updateBooks: (Platform.Genre) -> Unit = {}
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        PlatformSelectionList(click = updateGenre)
        GenreSelectionList(
            options = state.genres,
            click = updateBooks)
        BookList(state.books) { books ->
            // 순환 참조 문제 module 에서 module 호출
            BookDetailActivity.startBookDetail(context, books)
        }
    }
}

@Composable
private fun Loading(updateGenre: (Platform) -> Unit = {},) {
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        PlatformSelectionList(click = updateGenre)
    }
}


@Preview
@Composable
private fun PreviewHomeScreen() {
    val state = HomeStateData(
        listOf(Platform.KYOBO.국문),
        listOf(MainBook("", "", "", ""))
    )

    AppTheme {
        HomeScreen(state)
    }
}

@Preview
@Composable
private fun PreviewLoading() {
    AppTheme {
        Loading()
    }
}