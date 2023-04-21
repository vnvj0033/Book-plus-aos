package com.vnvj0033.bookplus.feature.favoritegenre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.model.Book
import com.vnvj0033.bookplus.data.model.MainBook
import com.vnvj0033.bookplus.data.model.Platform
import com.vnvj0033.bookplus.data.model.toMainBook
import com.vnvj0033.bookplus.data.repository.book.BookRepository
import com.vnvj0033.bookplus.data.repository.genre.GenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteGenreViewModel @Inject constructor(
    private val bookRepository: BookRepository,
    private val genreRepository: GenreRepository
) : ViewModel() {

    private val genre = MutableStateFlow(emptyList<Platform.Genre>())
    private val books = MutableStateFlow(emptyList<Book>())

    val uiState: StateFlow<FavoriteGenreUiState> =
        favoriteGenreUiState(genre, books).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = FavoriteGenreUiState.Loading
        )

    fun loadUserFavoriteGenres() = viewModelScope.launch {
        genreRepository.fetchGenresForId("").collect {
            genre.value = it
        }
    }

    fun refreshListWithFilter(genre: Platform.Genre) = viewModelScope.launch {
        bookRepository.fetchBookForGenre(genre).collect {
            books.value = it
        }
    }

}


private fun favoriteGenreUiState(
    genresFlow: Flow<List<Platform.Genre>>,
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
