package com.vnvj0033.bookplus.data.repository.book

import com.vnvj0033.bookplus.data.model.Book
import com.vnvj0033.bookplus.data.model.Platform
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakeBookRepository @Inject constructor() : BookRepository {
    private val userDb = hashMapOf<String, List<Book>>()

    override fun sendBookForId(userId: String, books: List<Book>) {
        userDb[userId] = books
    }

    override fun fetchBookForId(userId: String): Flow<List<Book>> = flowOf(
        userDb[userId] ?: emptyList()
    )

    override fun fetchBookForGenre(genre: Platform.Genre): Flow<List<Book>> = flowOf(
        when (genre) {
            Platform.KYOBO.국문 -> listOf(
                Book(0, "url", "kyobo1", "writer", "summary"),
                Book(0, "url", "kyobo2", "writer", "summary"),
                Book(0, "url", "kyobo3", "writer", "summary"),
                Book(0, "url", "kyobo4", "writer", "summary"),
                Book(0, "url", "kyobo5", "writer", "summary")
            )
            Platform.ALADIN.aladin1 -> listOf(
                Book(0, "url", "aladin1", "writer", "summary"),
                Book(0, "url", "aladin2", "writer", "summary"),
                Book(0, "url", "aladin3", "writer", "summary"),
                Book(0, "url", "aladin4", "writer", "summary"),
                Book(0, "url", "aladin5", "writer", "summary")
            )
            Platform.YES24.yes24a -> listOf(
                Book(0, "url", "yes24a", "writer", "summary"),
                Book(0, "url", "yes24b", "writer", "summary"),
                Book(0, "url", "yes24c", "writer", "summary"),
                Book(0, "url", "yes24d", "writer", "summary"),
                Book(0, "url", "yes24e", "writer", "summary"),
            )
            else -> listOf()
        }
    )


}