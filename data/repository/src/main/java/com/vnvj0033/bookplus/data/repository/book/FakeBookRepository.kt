package com.vnvj0033.bookplus.data.repository.book

import com.vnvj0033.bookplus.data.model.Book
import com.vnvj0033.bookplus.data.model.Constant
import javax.inject.Inject

class FakeBookRepository @Inject constructor() : BookRepository {
    private val userDb = hashMapOf<String, List<Book>>()

    override fun saveBookForId(userId: String, books: List<Book>) {
        userDb[userId] = books
    }

    override fun loadBookForId(userId: String): List<Book> =
        userDb[userId] ?: emptyList()

    override fun loadBookForGenre(genre: String): List<Book> =
        when (genre) {
            Constant.Genre.kyobo1 -> listOf(
                Book(0, "url", "kyobo1", "writer", "summary"),
                Book(0, "url", "kyobo2", "writer", "summary"),
                Book(0, "url", "kyobo3", "writer", "summary"),
                Book(0, "url", "kyobo4", "writer", "summary"),
                Book(0, "url", "kyobo5", "writer", "summary")
            )
            Constant.Genre.aladin1 -> listOf(
                Book(0, "url", "aladin1", "writer", "summary"),
                Book(0, "url", "aladin2", "writer", "summary"),
                Book(0, "url", "aladin3", "writer", "summary"),
                Book(0, "url", "aladin4", "writer", "summary"),
                Book(0, "url", "aladin5", "writer", "summary")
            )
            Constant.Genre.yes24a -> listOf(
                Book(0, "url", "yes24a", "writer", "summary"),
                Book(0, "url", "yes24b", "writer", "summary"),
                Book(0, "url", "yes24c", "writer", "summary"),
                Book(0, "url", "yes24d", "writer", "summary"),
                Book(0, "url", "yes24e", "writer", "summary"),
            )
            else -> listOf()
        }


}