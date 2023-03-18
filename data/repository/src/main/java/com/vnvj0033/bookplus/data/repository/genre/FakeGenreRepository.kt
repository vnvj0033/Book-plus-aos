package com.vnvj0033.bookplus.data.repository.genre

import javax.inject.Inject

class FakeGenreRepository @Inject constructor() : GenreRepository {
    private val genreDb = hashMapOf<String, List<String>>()
    override fun saveGenres(userId: String, genre: List<String>) {
        genreDb[userId] = genre
    }

    override fun loadGenres(userId: String): List<String> =
        genreDb[userId] ?: emptyList()

}