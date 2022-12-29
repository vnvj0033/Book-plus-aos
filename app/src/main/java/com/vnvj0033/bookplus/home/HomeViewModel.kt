package com.vnvj0033.bookplus.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.domain.model.toMainBook
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    bookRepository: BookRepository
): ViewModel() {

    private var platform: String
        get() = savedStateHandle["platform"] ?: ""
        set(value) { savedStateHandle["platform"] = value }


    val homeUiState: StateFlow<HomeUiState> = with(bookRepository) {
        combine(genres, books) { genres, books ->
            if (genres.isNotEmpty() && books.isNotEmpty()) {
                HomeUiState.Success(
                    HomeStateData(
                        platform,
                        genres,
                        books.map { it.toMainBook() }
                    )
                )
            } else {
                HomeUiState.Error
            }
        }
    } .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = HomeUiState.Loading
    )

}

data class HomeStateData(
    val platform: String,
    val genres: List<String>,
    val books: List<MainBook>
)

sealed interface HomeUiState {
    data class Success(val homeStateData: HomeStateData) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}
