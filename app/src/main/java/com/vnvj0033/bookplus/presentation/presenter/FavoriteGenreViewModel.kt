package com.vnvj0033.bookplus.presentation.presenter

import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.presentation.ui.FilterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.single
import javax.inject.Inject

@HiltViewModel
class FavoriteGenreViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {
    val filterState = FilterState()

    suspend fun updateFilter(genre: String) {
        bookRepository.loadBooks("", genre).single()
    }

}
