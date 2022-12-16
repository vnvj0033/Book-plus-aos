package com.vnvj0033.bookplus.presentation.presenter

import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.data.entity.Book
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.presentation.ui.state.BookListState
import com.vnvj0033.bookplus.presentation.ui.state.GenreSelectionListState
import com.vnvj0033.bookplus.presentation.ui.state.PlatformsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.single
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
        val genres = bookRepository.loadGenres(platform).single()

        genreState.options.clear()
        genreState.options.addAll(genres)
    }

    suspend fun loadBooks() {
        val selectedGenre = genreState.selectGenre

        val books = bookRepository.loadBooks(platformsState.selectedTitle, selectedGenre).single().map { book ->
            book.toMainBook()
        }

        bookListState.books.clear()
        bookListState.books.addAll(books)
    }

    private fun Book.toMainBook() = MainBook(imgUtl, title, writer, summary)
}
