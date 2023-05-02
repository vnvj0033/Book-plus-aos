package com.vnvj0033.bookplus.feature.subscript

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

    val genres: StateFlow<List<String>> = platform.flatMapLatest { mapPlatform ->
        genreRepository.fetchGenresForPlatform(mapPlatform)
    }.map { genres -> genres.map { it.name() } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val userGenres: Flow<List<String>> = userId.flatMapLatest {
        genreRepository.fetchGenresForId(it)
    }.map { genres -> genres.map { it.name() } }

    fun updateGenre(strGenres: Set<String>) {
        val genres = arrayListOf<Platform.Genre>()
        Platform.platforms().forEach {
            it.genres().forEach { genre ->
                if (strGenres.contains(genre.name())) {
                    genres.add(genre)
                }
            }
        }

        genreRepository.sendGenresForId(userId.value, genres)
    }

    fun updateOptions(newPlatform: Platform) {
        viewModelScope.launch {
            platform.emit(newPlatform)
        }
    }
}