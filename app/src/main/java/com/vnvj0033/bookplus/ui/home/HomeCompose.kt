package com.vnvj0033.bookplus.ui.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vnvj0033.bookplus.ui.bookdetail.BookDetailActivity
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.component.BookList
import com.vnvj0033.bookplus.ui.component.GenreSelectionList
import com.vnvj0033.bookplus.ui.component.PlatformSelectionList
import com.vnvj0033.bookplus.ui.component.state.PlatformsState

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
            HomeScreen(state = (uiState as HomeUiState.Success).homeStateData)
        }
    }

}

@Composable
fun HomeScreen(state: HomeStateData) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        PlatformSelectionList(state.platformState) { selectedTitle ->
            state.platformState.selectedTitle = selectedTitle
        }
        GenreSelectionList(
            options = state.genres
        )
        BookList(state.books) {
            openBookDetail(context, it)
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

private fun openBookDetail(context: Context, book: MainBook) {
    val intent = Intent(context, BookDetailActivity::class.java)
    intent.putExtra(BookDetailActivity.BUNDLE_KEY_NAME_BOOK, book)
    context.startActivity(intent)
}


@Preview
@Composable
private fun PreviewHomeScreen() {
    val state = HomeStateData(
        PlatformsState(),
        listOf("123", "234"),
        listOf(
            MainBook("", "", "", "")
        )
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