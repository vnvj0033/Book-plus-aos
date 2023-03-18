package com.vnvj0033.bookplus.data.repository.genre

interface GenreRepository {
    fun saveGenres(userId: String, genre: List<String>)
    fun loadGenres(userId: String): List<String>
}
