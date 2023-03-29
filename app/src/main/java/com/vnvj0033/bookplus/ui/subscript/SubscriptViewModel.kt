package com.vnvj0033.bookplus.ui.subscript

import androidx.lifecycle.ViewModel
import com.vnvj0033.bookplus.data.model.Constant
import com.vnvj0033.bookplus.data.repository.genre.GenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SubscriptViewModel @Inject constructor(
    private val genreRepository: GenreRepository
) : ViewModel() {

    val options = MutableStateFlow(
        genreRepository.loadGenresForPlatform(
            Constant.Platform.loadItems().first()
        )
    )
    val selectedGenreState = MutableStateFlow(
        setOf(
            "abc",
            "bdds",
            "abc123",
            "baasddds",
            "오나라라",
            "오나라라ㅏ라",
            "아주나라라라",
            "동해물과백두산이마르고닭도록하느님이보우하사우리나라만세무궁화삼천리화려강산",
            "대한사람 대한으로 길이보전하세"
        )
    )

    fun updateSelectedGenre(set: Set<String>) {
        selectedGenreState.value = set
    }

    fun updateOptions(platform: String) {
        options.value = genreRepository.loadGenresForPlatform(platform)
    }
}