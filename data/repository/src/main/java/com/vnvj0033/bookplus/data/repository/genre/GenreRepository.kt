package com.vnvj0033.bookplus.data.repository.genre

interface GenreRepository {
    fun saveGenresForId(userId: String, genre: List<String>)
    fun loadGenresForId(userId: String): List<String>

    fun loadGenresForPlatform(platform: String): List<String>
}
