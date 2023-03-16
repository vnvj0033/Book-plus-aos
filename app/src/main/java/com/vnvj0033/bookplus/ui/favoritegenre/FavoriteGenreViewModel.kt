package com.vnvj0033.bookplus.ui.favoritegenre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Book
import com.example.model.MainBook
import com.example.model.toMainBook
import com.example.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class FavoriteGenreViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {

    private val genre = MutableStateFlow(emptyList<String>())
    private val books = MutableStateFlow(emptyList<Book>())

    val uiState: StateFlow<FavoriteGenreUiState> =
        favoriteGenreUiState(genre, books).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = FavoriteGenreUiState.Loading
        )

    fun loadUserFavoriteGenres() {
        genre.value = bookRepository.loadGenreForUserId("")
    }

    fun refreshListWithFilter(genre: String) {
        books.value = bookRepository.loadBooksForGenre(genre)
    }

}


private fun favoriteGenreUiState(
    genresFlow: Flow<List<String>> ,
    booksFlow: Flow<List<Book>>,
) = combine(genresFlow, booksFlow) { genres, books ->
    val stateData = FavoriteGenreStateData(
        genres,
        books.map { it.toMainBook() }
    )

    if (genres.isNotEmpty() || books.isNotEmpty()) {
        FavoriteGenreUiState.Success(stateData)
    } else {
        FavoriteGenreUiState.Loading
    }
}


data class FavoriteGenreStateData(
    val filterOption: List<String> = listOf("1", "2", "3", "4", "5", "6", "7", "8"),
    var books: List<MainBook> = emptyList()
)

sealed interface FavoriteGenreUiState {
    data class Success(val favoriteGenreStateData: FavoriteGenreStateData) : FavoriteGenreUiState
    object Loading : FavoriteGenreUiState
}
