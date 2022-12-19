package com.vnvj0033.bookplus.presentation.ui.state

import androidx.compose.runtime.mutableStateListOf
import com.vnvj0033.bookplus.domain.model.MainBook

class BookListState {
    var books = mutableStateListOf<MainBook>()
}
