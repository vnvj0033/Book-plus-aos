package com.vnvj0033.bookplus.ui.component.state

import com.vnvj0033.bookplus.domain.model.MainBook

data class BookListState (
    var books: List<MainBook> = listOf()
)
