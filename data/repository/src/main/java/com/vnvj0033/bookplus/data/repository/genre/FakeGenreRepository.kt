package com.vnvj0033.bookplus.data.repository.genre

import com.vnvj0033.bookplus.data.model.Platform
import javax.inject.Inject

class FakeGenreRepository @Inject constructor() : GenreRepository {
    private val genreDb = hashMapOf<String, List<String>>()

    override fun saveGenresForId(userId: String, genre: List<String>) {
        genreDb[userId] = genre
    }

    override fun loadGenresForId(userId: String): List<String> =
        genreDb[userId] ?: emptyList()

    override fun loadGenresForPlatform(platform: Platform): List<String> =
        when (platform) {
            Platform.KYOBO -> listOf(
                Platform.KYOBO.kyobo1,
                Platform.KYOBO.kyobo2,
                Platform.KYOBO.kyobo3,
                Platform.KYOBO.kyobo4,
                Platform.KYOBO.kyobo5,
            )
            Platform.ALADIN -> listOf(
                Platform.ALADIN.aladin1,
                Platform.ALADIN.aladin2,
                Platform.ALADIN.aladin3,
                Platform.ALADIN.aladin4,
                Platform.ALADIN.aladin5,
            )
            Platform.YES24 -> listOf(
                Platform.YES24.yes24a,
                Platform.YES24.yes24b,
                Platform.YES24.yes24c,
                Platform.YES24.yes24d,
                Platform.YES24.yes24e,
            )
            else -> listOf()
        }

}