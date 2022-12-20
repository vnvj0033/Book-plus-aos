package com.vnvj0033.bookplus.presentation.presenter

import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.domain.model.toMainBook
import com.vnvj0033.bookplus.presentation.ui.FilterState
import com.vnvj0033.bookplus.presentation.ui.state.BookListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.single
import javax.inject.Inject

@HiltViewModel
class FavoriteGenreViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {
    val bookListState = BookListState()
    val filterState = FilterState().apply {
        // test filter option
        option.addAll(listOf("1", "2", "3", "4"))
    }

    suspend fun refreshListWithFilter(genre: String) {
        val books = bookRepository.loadFavoriteBooks("", genre).single().map {
            it.toMainBook()
        }

        bookListState.books.clear()
        bookListState.books.addAll(books)
    }

}
