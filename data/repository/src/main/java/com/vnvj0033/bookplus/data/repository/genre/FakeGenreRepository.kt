package com.vnvj0033.bookplus.data.repository.genre

import com.vnvj0033.bookplus.data.model.Platform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakeGenreRepository @Inject constructor() : GenreRepository {
    private val genreDb = hashMapOf<String, MutableStateFlow<List<Platform.Genre>>>()

    override fun sendGenresForId(userId: String, genre: List<Platform.Genre>) {
        if (genreDb[userId] == null) {
            genreDb[userId] = MutableStateFlow(genre)
        } else {
            genreDb[userId]?.value = genre
        }
    }

    override fun fetchGenresForId(userId: String) =
        if (genreDb[userId] == null) {
            genreDb[userId] = MutableStateFlow(emptyList())
            requireNotNull(genreDb[userId])
        } else {
            requireNotNull(genreDb[userId])
        }

    override fun fetchGenresForPlatform(platform: Platform) = flowOf(
        when (platform) {
            Platform.KYOBO -> listOf(
                Platform.KYOBO.국문,
                Platform.KYOBO.인문학,
                Platform.KYOBO.생활,
                Platform.KYOBO.영문,
                Platform.KYOBO.컴퓨터_과학,
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