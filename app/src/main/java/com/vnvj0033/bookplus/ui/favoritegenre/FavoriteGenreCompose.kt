package com.vnvj0033.bookplus.ui.favoritegenre

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.component.BookList
import com.vnvj0033.bookplus.ui.component.Filter
import kotlinx.coroutines.launch

@Composable
fun FavoriteGenreCompose(
    viewModel: FavoriteGenreViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is FavoriteGenreUiState.Loading -> {
            Loading()
        }
        is FavoriteGenreUiState.Success -> {
            val composeScope = rememberCoroutineScope()
            val state = (uiState as FavoriteGenreUiState.Success).favoriteGenreStateData
            FavoriteGenreCompose(state) { genre ->
                composeScope.launch {
                    viewModel.refreshListWithFilter(genre)
                }
            }
        }
    }
    
}

@Composable
private fun FavoriteGenreCompose(
    state: FavoriteGenreStateData,
    refreshListWithFilter: (String) -> Unit = {}
) {
    val composeScope = rememberCoroutineScope()
    
    val filterState = state.filterState

    val bookState = state.bookListState
    
    LaunchedEffect(true) {
        if (filterState.option.isNotEmpty()) {
            composeScope.launch {
                refreshListWithFilter(filterState.option[0])
            }
        }
    }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "SUBSCRIPT")
            Filter(filterState) { filterGenre ->
                composeScope.launch {
                    refreshListWithFilter(filterGenre)
                }
            }
        }
        Divider()
        BookList(bookState.books)
    }
}

@Composable
private fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "LOADING...")
    }
}

@Composable
@Preview
private fun PreviewSuccess() {
    AppTheme {
        FavoriteGenreCompose(FavoriteGenreStateData())
    }
}

@Composable
@Preview
private fun PreviewLoading() {
    AppTheme {
        Loading()
    }
}
