package com.vnvj0033.bookplus.data.repository.genre

import javax.inject.Inject

class FakeGenreRepository @Inject constructor() : GenreRepository {
    override fun saveGenres(userId: String, genre: List<String>) {
        TODO("Not yet implemented")
    }

    override fun loadGenres(userId: String): List<String> {
        TODO("Not yet implemented")
    }

}