package com.vnvj0033.bookplus.feature.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.common.feature.getSavableMutableStateFlow
import com.vnvj0033.bookplus.data.model.MainBook
import javax.inject.Inject

class BookDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _book = savedStateHandle.getSavableMutableStateFlow("book", MainBook())
    val book = _book.asStateFlow()

    fun setMainBook(newBook: MainBook) {
        _book.value = newBook

    }
}