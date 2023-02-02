package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entity.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakeBookRepo @Inject constructor() : BookRepository {

    private var genre = emptyList<String>()

    override val genres: Flow<List<String>>
        get() = flowOf(genre)

    override val books: Flow<List<Book>>
        get() = flowOf(listOf(Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book()))

    override fun updateGenre(platform: String) {
        genre = if (platform == "kyobo") {
            listOf("kyobo", "kyobo2", "kyobo3", "kyobo4", "kyobo5", "kyobo6", "kyobo7", "kyobo8")
        } else if (platform == "yes24") {
            listOf("yes24a", "yes24b", "yes24c", "yes24d", "yes24e", "yes24f", "yes24g", "yes24h")
        } else if (platform == "aladin") {
            listOf("aladin1", "aladin2", "aladin3", "aladin4", "aladin5", "aladin6", "aladin7", "aladin8")
        } else {
            listOf("1", "2", "3", "4", "5", "6", "7", "8")
        }
    }

    override suspend fun loadFavoriteBooks(userId: String, genre: String): Flow<List<Book>> {
        val list = if (genre == "1") {
            listOf(Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book())
        } else if (genre == "2" || genre == "3") {
            listOf(Book(), Book(), Book())
        } else {
            listOf(Book())
        }

        return flowOf(list)
    }
}