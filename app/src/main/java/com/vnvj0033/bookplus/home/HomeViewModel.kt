package com.vnvj0033.bookplus.home

import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.domain.model.toMainBook
import com.vnvj0033.bookplus.ui.state.BookListState
import com.vnvj0033.bookplus.ui.state.GenreSelectionListState
import com.vnvj0033.bookplus.ui.state.PlatformsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {
    val genreState = GenreSelectionListState()
    val bookListState = BookListState()
    val platformsState = PlatformsState()


    suspend fun loadGenre() {
        val platform = platformsState.selectedTitle
        bookRepository.loadGenres(platform).collect {
            genreState.options.clear()
            genreState.options.addAll(it)
        }

    }

    suspend fun loadBooks() {
        val selectedGenre = genreState.selectGenre

        bookRepository.loadBooks(platformsState.selectedTitle, selectedGenre).collect { books ->
            val mainBooks = books.map { book ->
                book.toMainBook()
            }

            bookListState.books.clear()
            bookListState.books.addAll(mainBooks)
        }
    }
}
