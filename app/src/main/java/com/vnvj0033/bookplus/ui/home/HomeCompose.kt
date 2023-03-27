package com.vnvj0033.bookplus.ui.home

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
import com.vnvj0033.bookplus.data.model.Constant
import com.vnvj0033.bookplus.data.model.MainBook
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.BookList
import com.vnvj0033.bookplus.ui.GenreSelectionList
import com.vnvj0033.bookplus.ui.PlatformSelectionList
import com.vnvj0033.bookplus.ui.bookdetail.BookDetailActivity

@Composable
fun HomeCompose(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when(uiState) {
        is HomeUiState.Loading -> {
            Loading()
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
        viewModel.updateGenre(Constant.Platform.KYOBO)
    }

}

@Composable
fun HomeScreen(
    state: HomeStateData,
    updateGenre: (String) -> Unit = {},
    updateBooks: (String) -> Unit = {}
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
            BookDetailActivity.openBookDetail(context, books)
        }
    }
}

@Composable
private fun Loading() {
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        PlatformSelectionList()
        GenreSelectionList(listOf())
        BookList()
    }
}


@Preview
@Composable
private fun PreviewHomeScreen() {
    val state = HomeStateData(
        listOf("123", "234"),
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