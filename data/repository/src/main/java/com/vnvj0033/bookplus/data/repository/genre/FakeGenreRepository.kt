package com.vnvj0033.bookplus.data.repository.genre

import com.vnvj0033.bookplus.data.model.Platform
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakeGenreRepository @Inject constructor() : GenreRepository {
    private val genreDb = hashMapOf<String, List<Platform.Genre>>()

    override fun sendGenresForId(userId: String, genre: List<Platform.Genre>) {
        genreDb[userId] = genre
    }

    override fun fetchGenresForId(userId: String) = flowOf(
        genreDb[userId] ?: emptyList()
    )

    override fun fetchGenresForPlatform(platform: Platform) = flowOf(
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
    )

}