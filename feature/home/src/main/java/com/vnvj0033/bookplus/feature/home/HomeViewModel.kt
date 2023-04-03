package com.vnvj0033.bookplus.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.model.*
import com.vnvj0033.bookplus.data.repository.book.BookRepository
import com.vnvj0033.bookplus.data.repository.genre.GenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookRepository: BookRepository,
    private val genreRepository: GenreRepository
) : ViewModel() {

    private val platform = MutableSharedFlow<Platform>()
    private val genres: Flow<List<Platform.Genre>> = platform.flatMapLatest {
        genreRepository.fetchGenresForPlatform(it)
    }
    private val selectedGenre = MutableSharedFlow<Platform.Genre>()
    private val books = selectedGenre.flatMapLatest {
        bookRepository.fetchBookForGenre(it)
    }

    val uiState: StateFlow<HomeUiState> =
        homeUiState(genres, books).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState.Loading
        )

    fun updateGenre(newPlatform: Platform) {
        viewModelScope.launch {
            platform.emit(newPlatform)
        }
    }

    fun updateBooks(newGenre: Platform.Genre) {
        viewModelScope.launch {
            selectedGenre.emit(newGenre)
        }
    }
}

private fun homeUiState(
    genres: Flow<List<Platform.Genre>>,
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
    val genres: List<Platform.Genre>,
    val books: List<MainBook>
)

sealed interface HomeUiState {
    data class Success(val homeStateData: HomeStateData) : HomeUiState
    object Loading : HomeUiState
}
