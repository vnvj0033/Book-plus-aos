package com.vnvj0033.bookplus.ui.favoritegenre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.domain.model.toMainBook
import com.vnvj0033.bookplus.ui.FilterState
import com.vnvj0033.bookplus.ui.component.state.BookListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavoriteGenreViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {

    private val stateData: FavoriteGenreStateData = FavoriteGenreStateData()

    val uiState: StateFlow<FavoriteGenreUiState> =
        favoriteGenreUiState(bookRepository, stateData).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = FavoriteGenreUiState.Loading
        )

    suspend fun refreshListWithFilter(genre: String) {
        bookRepository.loadFavoriteBooks("", genre).collect { books ->
            val mainBook = books.map {
                it.toMainBook()
            }
            stateData.bookListState.books = mainBook
        }
    }

}


private fun favoriteGenreUiState(
    bookRepository: BookRepository,
    stateData: FavoriteGenreStateData
) = with(bookRepository) {
    combine(genres, books) { genres, books ->
        if (genres.isNotEmpty() && books.isNotEmpty()) {
            FavoriteGenreUiState.Success(stateData)
        } else {
            FavoriteGenreUiState.Loading
        }
    }
}

data class FavoriteGenreStateData(
    val filterState: FilterState = FilterState(),
    val bookListState: BookListState = BookListState()
)

sealed interface FavoriteGenreUiState {
    data class Success(val favoriteGenreStateData: FavoriteGenreStateData) : FavoriteGenreUiState
    object Loading : FavoriteGenreUiState
}
