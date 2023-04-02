package com.vnvj0033.bookplus.ui.subscript

import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.data.model.Platform
import com.vnvj0033.bookplus.data.repository.genre.GenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SubscriptViewModel @Inject constructor(
    private val genreRepository: GenreRepository
) : ViewModel() {

    val options = MutableStateFlow(
        genreRepository.loadGenresForPlatform(Platform.KYOBO)
    )
    val selectedGenreState = MutableStateFlow(
        genreRepository.loadGenresForId("test_id").toSet()
    )

    fun updateSelectedGenre(set: Set<String>) {
        genreRepository.saveGenresForId("test_id", set.toList())
        selectedGenreState.value = set
    }

    fun updateOptions(platform: Platform) {
        options.value = genreRepository.loadGenresForPlatform(platform)
    }
}