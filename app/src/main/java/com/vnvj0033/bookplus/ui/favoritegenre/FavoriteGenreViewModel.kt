package com.vnvj0033.bookplus.ui.favoritegenre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.entity.Book
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.domain.model.toMainBook
import com.vnvj0033.bookplus.ui.component.state.BookListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class FavoriteGenreViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {

    private val genre = MutableStateFlow(bookRepository.genres)
    private val books = MutableStateFlow(bookRepository.books)

    private val stateData: FavoriteGenreStateData = FavoriteGenreStateData()

    val uiState: StateFlow<FavoriteGenreUiState> =
        favoriteGenreUiState(genre, books, stateData).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = FavoriteGenreUiState.Loading
        )

    fun refreshListWithFilter(genre: String) {
        val books = bookRepository.updateBooks("", genre).map {
            it.toMainBook()
        }
        stateData.bookListState.books = books
    }

}


private fun favoriteGenreUiState(
    genresFlow: Flow<List<String>> ,
    booksFlow: Flow<List<Book>>,
    stateData: FavoriteGenreStateData
) = combine(genresFlow, booksFlow) { genres, books ->
//    if (genres.isNotEmpty() && books.isNotEmpty()) {
        FavoriteGenreUiState.Success(stateData)
//    } else {
//        FavoriteGenreUiState.Loading
//    }
}


data class FavoriteGenreStateData(
    val filterOption: List<String> = listOf("kyobo","yes24","aladin"),
    val bookListState: BookListState = BookListState()
)

sealed interface FavoriteGenreUiState {
    data class Success(val favoriteGenreStateData: FavoriteGenreStateData) : FavoriteGenreUiState
    object Loading : FavoriteGenreUiState
}
