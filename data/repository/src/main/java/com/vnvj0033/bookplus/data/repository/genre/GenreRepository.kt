package com.vnvj0033.bookplus.data.repository.genre

import com.vnvj0033.bookplus.data.model.Platform

interface GenreRepository {
    fun saveGenresForId(userId: String, genre: List<String>)
    fun loadGenresForId(userId: String): List<String>

    fun loadGenresForPlatform(platform: Platform): List<String>
}
