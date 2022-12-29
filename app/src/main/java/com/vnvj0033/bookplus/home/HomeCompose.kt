package com.vnvj0033.bookplus.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vnvj0033.bookplus.data.repository.FakeBookRepo
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.BookDetailActivity
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.component.BookList
import com.vnvj0033.bookplus.ui.component.GenreSelectionList
import com.vnvj0033.bookplus.ui.component.PlatformSelectionList
import kotlinx.coroutines.launch

@Composable
fun HomeCompose(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val composeScope = rememberCoroutineScope()

    val platformListState = viewModel.platformsState
    val genreState = viewModel.genreState
    val bookListState = viewModel.bookListState

    LaunchedEffect(true) {
        viewModel.loadGenre()
        viewModel.loadBooks()
    }

    Column(modifier = modifier) {
        PlatformSelectionList(platformListState) {
            composeScope.launch {
                viewModel.loadGenre()
                viewModel.loadBooks()
            }
        }
        GenreSelectionList(genreState) {
            composeScope.launch {
                viewModel.loadBooks()
            }
        }
        BookList(bookListState) { book ->
            openBookDetail(context, book)
        }
    }
}

private fun openBookDetail(context: Context, book: MainBook) {
    val intent = Intent(context, BookDetailActivity::class.java)
    intent.putExtra(BookDetailActivity.BUNDLE_KEY_NAME_BOOK, book)
    context.startActivity(intent)
}


@Preview
@Composable
private fun Preview() {
    AppTheme {
        HomeCompose(
            viewModel = HomeViewModel(FakeBookRepo())
        )
    }
}
