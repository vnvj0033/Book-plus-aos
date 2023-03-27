package com.vnvj0033.bookplus.data.repository.genre

import com.vnvj0033.bookplus.data.model.Constant
import javax.inject.Inject

class FakeGenreRepository @Inject constructor() : GenreRepository {
    private val genreDb = hashMapOf<String, List<String>>()

    override fun saveGenresForId(userId: String, genre: List<String>) {
        genreDb[userId] = genre
    }

    override fun loadGenresForId(userId: String): List<String> =
        genreDb[userId] ?: emptyList()

    override fun loadGenresForPlatform(platform: String): List<String> =
        when (platform) {
            Constant.Genre.kyobo1 -> listOf(
                Constant.Genre.kyobo1,
                Constant.Genre.kyobo2,
                Constant.Genre.kyobo3,
                Constant.Genre.kyobo4,
                Constant.Genre.kyobo5,
            )
            Constant.Genre.aladin1 -> listOf(
                Constant.Genre.aladin1,
                Constant.Genre.aladin2,
                Constant.Genre.aladin3,
                Constant.Genre.aladin4,
                Constant.Genre.aladin5,
            )
            Constant.Genre.yes24a -> listOf(
                Constant.Genre.yes24a,
                Constant.Genre.yes24b,
                Constant.Genre.yes24c,
                Constant.Genre.yes24d,
                Constant.Genre.yes24e,
            )
            else -> listOf()
        }

}