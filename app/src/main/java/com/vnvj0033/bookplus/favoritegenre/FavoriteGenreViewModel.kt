package com.vnvj0033.bookplus.favoritegenre

import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.domain.model.toMainBook
import com.vnvj0033.bookplus.ui.FilterState
import com.vnvj0033.bookplus.ui.state.BookListState
import dagger.hilt.android.lifecycle.HiltViewModel
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
        bookRepository.loadFavoriteBooks("", genre).collect { books ->
            val mainBook = books.map {
                it.toMainBook()
            }
            bookListState.books = mainBook
        }
    }

}
