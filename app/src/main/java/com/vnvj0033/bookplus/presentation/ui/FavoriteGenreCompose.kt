package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnvj0033.bookplus.data.repository.FakeBookRepo
import com.vnvj0033.bookplus.presentation.presenter.FavoriteGenreViewModel
import com.vnvj0033.bookplus.presentation.ui.component.BookList
import kotlinx.coroutines.launch

@Composable
fun FavoriteGenreCompose(
    modifier: Modifier = Modifier,
    viewModel: FavoriteGenreViewModel
) {
    val composeScope = rememberCoroutineScope()
    
    LaunchedEffect(true) {
        if (viewModel.filterState.option.isNotEmpty()) {
            composeScope.launch {
                viewModel.updateFilter(viewModel.filterState.option[0])
            }
        }
    }

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "SUBSCRIPT")
            Filter(viewModel.filterState) { filterGenre ->
                composeScope.launch {
                    viewModel.updateFilter(filterGenre)
                }
            }
        }
        Divider()
        BookList()
    }
}

@Composable
@Preview
private fun Preview() {
    AppTheme {
        FavoriteGenreCompose(viewModel = FavoriteGenreViewModel(FakeBookRepo()))
    }
}
