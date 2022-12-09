package com.vnvj0033.bookplus.presentation.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.presentation.controller.BookDetailActivity
import com.vnvj0033.bookplus.presentation.presenter.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun MainCompose(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val composeScope = rememberCoroutineScope()

    val viewModel = MainViewModel()

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

