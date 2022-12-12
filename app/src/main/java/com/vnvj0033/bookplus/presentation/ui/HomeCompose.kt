package com.vnvj0033.bookplus.presentation.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.vnvj0033.bookplus.data.repository.FakeBookRepo
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.presentation.controller.BookDetailActivity
import com.vnvj0033.bookplus.presentation.presenter.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeCompose(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
    val context = LocalContext.current
    val composeScope = rememberCoroutineScope()

    Column(modifier = modifier) {
        PlatformSelectionList(viewModel.platformStates) {
            composeScope.launch {
                viewModel.loadGenre()
                viewModel.loadBooks()
            }
        }
        GenreSelectionList(viewModel.genreState) {
            composeScope.launch {
                viewModel.loadBooks()
            }
        }
        BookList(viewModel.bookListState) { book ->
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
