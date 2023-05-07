package com.vnvj0033.bookplus.feature.favoritegenre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.model.Book
import com.vnvj0033.bookplus.data.model.MainBook
import com.vnvj0033.bookplus.data.model.Platform
import com.vnvj0033.bookplus.data.model.toMainBook
import com.vnvj0033.bookplus.data.repository.book.BookRepository
import com.vnvj0033.bookplus.data.repository.genre.GenreRepository
import com.vnvj0033.bookplus.data.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class FavoriteGenreViewModel @Inject constructor(
    private val bookRepository: BookRepository,
    private val genreRepository: GenreRepository,
    userRepository: UserRepository
) : ViewModel() {

    private val userId = MutableStateFlow(userRepository.userInfo.userId)

    private val genres = userId.flatMapLatest {
        genreRepository.fetchGenresForId(it)
    }

    private val books = MutableStateFlow<List<Book>>(emptyList())

    val uiState: StateFlow<FavoriteGenreUiState> =
        favoriteGenreUiState(genres, books).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = FavoriteGenreUiState.Empty
        )

    fun refreshListWithFilter(genre: Platform.Genre) = viewModelScope.launch {
        bookRepository.fetchBookForGenre(genre).collectLatest {
            books.value = it.filter { book -> book.genre == genre.name() }
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
        FavoriteGenreUiState.Empty
    }
}


data class FavoriteGenreStateData(
    val filterOption: List<Platform.Genre> = emptyList(),
    var books: List<MainBook> = emptyList()
)

sealed interface FavoriteGenreUiState {
    data class Success(val favoriteGenreStateData: FavoriteGenreStateData) : FavoriteGenreUiState
    object Empty : FavoriteGenreUiState
}
