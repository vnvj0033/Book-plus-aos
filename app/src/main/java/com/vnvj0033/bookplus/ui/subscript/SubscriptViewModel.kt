package com.vnvj0033.bookplus.ui.subscript

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.model.Platform
import com.vnvj0033.bookplus.data.repository.genre.GenreRepository
import com.vnvj0033.bookplus.data.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class SubscriptViewModel @Inject constructor(
    private val genreRepository: GenreRepository,
    userRepository: UserRepository
) : ViewModel() {


    private val platform = MutableSharedFlow<Platform>()
    private val userId = MutableStateFlow(userRepository.userInfo.userId)

    val options: Flow<List<String>> = platform.flatMapLatest { mapPlatform ->
        genreRepository.fetchGenresForPlatform(mapPlatform)
    }.map { genres -> genres.map { it.name() } }

    val genres: Flow<List<String>> = userId.flatMapLatest {
        genreRepository.fetchGenresForId(it)
    }

    fun updateGenre(set: Set<String>) {
        genreRepository.sendGenresForId(userId.value, set.toList())
    }

    fun updateOptions(newPlatform: Platform) {
        viewModelScope.launch {
            platform.emit(newPlatform)
        }
    }
}