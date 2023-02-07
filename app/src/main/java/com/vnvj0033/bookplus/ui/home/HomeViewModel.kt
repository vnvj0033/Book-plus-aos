package com.vnvj0033.bookplus.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.entity.Book
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.domain.model.toMainBook
import com.vnvj0033.bookplus.ui.component.state.PlatformsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {

    private val genre = MutableStateFlow(bookRepository.genres)
    private val books = MutableStateFlow(bookRepository.books)

    val uiState: StateFlow<HomeUiState> =
        homeUiState(genre, books).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = HomeUiState.Loading
        )

    fun updateGenre(platform: String) {
        genre.value = bookRepository.updateGenre(platform = platform)

        if (genre.value.isNotEmpty()) {
            updateBooks(genre.value[0])
        }
    }

    fun updateBooks(newGenre: String) {
        books.value = bookRepository.updateBooks(
            userId = "",
            genre = newGenre
        )
    }
}

private fun homeUiState(
    genres: Flow<List<String>>,
    books: Flow<List<Book>>
): Flow<HomeUiState> {
    return combine(genres, books) { listOfGenre, listOfBook ->
        if (listOfGenre.isNotEmpty() && listOfBook.isNotEmpty()) {
            HomeUiState.Success(
                HomeStateData(
                    PlatformsState(),
                    listOfGenre,
                    listOfBook.map { it.toMainBook() }
                )
            )
        } else {
            HomeUiState.Loading
        }
    }
}

data class HomeStateData(
    var platformState: PlatformsState,
    val genres: List<String>,
    val books: List<MainBook>
)

sealed interface HomeUiState {
    data class Success(val homeStateData: HomeStateData) : HomeUiState
    object Loading : HomeUiState
}
