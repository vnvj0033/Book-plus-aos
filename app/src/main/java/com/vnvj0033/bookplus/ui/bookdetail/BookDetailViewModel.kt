package com.vnvj0033.bookplus.ui.bookdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.data.entity.Book
import com.vnvj0033.bookplus.util.getSavableMutableStateFlow
import javax.inject.Inject

class BookDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private var _book = savedStateHandle.getSavableMutableStateFlow("book", Book())
    val book = _book.asStateFlow()

}