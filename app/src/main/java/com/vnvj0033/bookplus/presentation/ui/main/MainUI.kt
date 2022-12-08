package com.vnvj0033.bookplus.presentation.ui.main

import android.content.Context
import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.presentation.controller.BookDetailActivity
import com.vnvj0033.bookplus.presentation.presenter.MainViewModel
import com.vnvj0033.bookplus.presentation.ui.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUI() {

    Scaffold(bottomBar = { BottomNavigation() }) {
        MainCompose(modifier = Modifier.padding(it))
    }
}

@Composable
private fun MainCompose(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val viewModel = MainViewModel()

    Column(modifier = modifier) {
        PlatformSelectionList(viewModel.platformStates) {
            viewModel.loadGenre()
        }
        GenreSelectionList(viewModel.genreState) {
            viewModel.loadBooks()
        }
        BookList { book ->
            openBookDetail(context, book)
        }
    }
}

private fun openBookDetail(context: Context, book: MainBook) {
    val intent = Intent(context, BookDetailActivity::class.java)
    intent.putExtra(BookDetailActivity.BUNDLE_KEY_NAME_BOOK, book)
    context.startActivity(intent)
}


@Preview(uiMode = UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        MainUI()
    }
}