package com.vnvj0033.bookplus.presentation.presenter

import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.R
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.data.repository.FakeBookRepo
import com.vnvj0033.bookplus.presentation.ui.state.GenreSelectionListState
import com.vnvj0033.bookplus.presentation.ui.state.PlatformSelectionState
import kotlinx.coroutines.flow.single

class MainViewModel: ViewModel() {
    private val kyobo = PlatformSelectionState("kyobo", R.drawable.logo_kyobo)
    private val yes24 = PlatformSelectionState("yes24", R.drawable.logo_yes24)
    private val aladin = PlatformSelectionState("aladin", R.drawable.logo_aladin)

    private val bookRepo: BookRepository = FakeBookRepo()

    val platformStates = listOf(kyobo, yes24, aladin, kyobo, yes24, aladin)
    val genreState = GenreSelectionListState()

    suspend fun loadGenre() {
        val genres = bookRepo.loadGenres().single()

        genreState.options.clear()
        genreState.options.addAll(genres)
    }

    suspend fun loadBooks() {
        val selectedGenre = genreState.selectGenre
        val book = bookRepo.loadBook(selectedGenre)

    }


}
