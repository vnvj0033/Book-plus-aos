package com.vnvj0033.bookplus.data.repository.genre

import com.vnvj0033.bookplus.data.model.Platform
import kotlinx.coroutines.flow.Flow

interface GenreRepository {
    fun sendGenresForId(userId: String, genre: List<Platform.Genre>)
    fun fetchGenresForId(userId: String): Flow<List<Platform.Genre>>

    fun fetchGenresForPlatform(platform: Platform): Flow<List<Platform.Genre>>
}
