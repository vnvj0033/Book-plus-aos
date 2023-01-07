package com.vnvj0033.bookplus.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.domain.model.MainBook
import com.vnvj0033.bookplus.domain.model.toMainBook
import com.vnvj0033.bookplus.ui.component.state.PlatformsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    bookRepository: BookRepository
): ViewModel() {

    val uiState: StateFlow<HomeUiState> =
        homeUiState(bookRepository).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = HomeUiState.Loading
        )

}

private fun homeUiState(
    bookRepository: BookRepository
) = with(bookRepository) {
    combine(genres, books) { genres, books ->
        if (genres.isNotEmpty() && books.isNotEmpty()) {
            HomeUiState.Success(
                HomeStateData(
                    PlatformsState(),
                    genres,
                    books.map { it.toMainBook() }
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
