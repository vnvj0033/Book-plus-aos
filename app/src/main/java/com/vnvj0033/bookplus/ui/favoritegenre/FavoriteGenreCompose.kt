package com.vnvj0033.bookplus.ui.favoritegenre

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.BookList
import com.vnvj0033.bookplus.ui.Filter
import com.vnvj0033.bookplus.ui.bookdetail.BookDetailActivity
import kotlinx.coroutines.launch

@Composable
fun FavoriteGenreCompose(
    viewModel: FavoriteGenreViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is FavoriteGenreUiState.Loading -> {
            viewModel.loadUserFavoriteGenres()
            Loading()
        }
        is FavoriteGenreUiState.Success -> {
            val state = (uiState as FavoriteGenreUiState.Success).favoriteGenreStateData
            if (state.filterOption.isNotEmpty()) {
                viewModel.refreshListWithFilter(state.filterOption[0])
            }
            FavoriteGenreCompose(
                state,
                viewModel::refreshListWithFilter
            )
        }
    }
    
}

@Composable
private fun FavoriteGenreCompose(
    state: FavoriteGenreStateData,
    refreshListWithFilter: (String) -> Unit = {}
) {
    val composeScope = rememberCoroutineScope()
    val context = LocalContext.current
    
    val option = state.filterOption

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
            Filter(option) { filterGenre ->
                composeScope.launch {
                    refreshListWithFilter(filterGenre)
                }
            }
        }
        Divider()
        BookList(state.books) { book ->
            BookDetailActivity.openBookDetail(context, book)
        }
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
