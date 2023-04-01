package com.vnvj0033.bookplus.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.model.*
import com.vnvj0033.bookplus.data.repository.book.BookRepository
import com.vnvj0033.bookplus.data.repository.genre.GenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookRepository: BookRepository,
    private val genreRepository: GenreRepository
): ViewModel() {

    private val genres = MutableStateFlow(emptyList<String>())
    private val books = MutableStateFlow(emptyList<Book>())

    val uiState: StateFlow<HomeUiState> =
        homeUiState(genres, books).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState.Loading
        )

    fun updateGenre(platform: Platform) {
        genres.value = genreRepository.loadGenresForPlatform(platform)

        if (genres.value.isNotEmpty()) {
            updateBooks(genres.value[0])
        } else {
            throw Exception("genres is empty")
        }
    }

    fun updateBooks(newGenre: String) {
        books.value = bookRepository.loadBookForGenre(newGenre)
    }
}

private fun homeUiState(
    genres: Flow<List<String>>,
    books: Flow<List<Book>>
): Flow<HomeUiState> {
    return combine(genres, books) { listOfGenre, listOfBook ->
        if (listOfGenre.isNotEmpty()) {
            val mainBook = listOfBook.map { it.toMainBook() }

            HomeUiState.Success(HomeStateData(listOfGenre, mainBook))
        } else {
            HomeUiState.Loading
        }
    }
}

data class HomeStateData(
    val genres: List<String>,
    val books: List<MainBook>
)

sealed interface HomeUiState {
    data class Success(val homeStateData: HomeStateData) : HomeUiState
    object Loading : HomeUiState
}
