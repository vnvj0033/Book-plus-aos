package com.vnvj0033.bookplus.data.repository.book

import com.vnvj0033.bookplus.data.datasource.api.BookApi
import com.vnvj0033.bookplus.data.model.Book
import com.vnvj0033.bookplus.data.model.Platform
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakeBookRepository @Inject constructor(
    private val bookApi: BookApi
) : BookRepository {
    private val userDb = hashMapOf<String, List<Book>>()

    override fun sendBookForId(userId: String, books: List<Book>) {
        userDb[userId] = books
    }

    override fun fetchBookForId(userId: String): Flow<List<Book>> = flowOf(
        userDb[userId] ?: emptyList()
    )

    override suspend fun fetchBookForGenre(genre: Platform.Genre): Flow<List<Book>> =
        flowOf(bookApi.getBooks("kyobo"))
//        flowOf(
//        when (genre) {
//            Platform.KYOBO.국문 -> listOf(
//                Book(0, 1,"url", "kyobo1", "writer", "summary", "국문"),
//                Book(0, 1,"url", "kyobo2", "writer", "summary", "국문"),
//                Book(0, 1,"url", "kyobo3", "writer", "summary", "국문"),
//                Book(0, 1,"url", "kyobo4", "writer", "summary", "국문"),
//                Book(0, 1,"url", "kyobo5", "writer", "summary", "국문")
//            )
//            Platform.ALADIN.aladin1 -> listOf(
//                Book(0, 1,"url", "aladin1", "writer", "summary", "aladin1"),
//                Book(0, 1,"url", "aladin2", "writer", "summary", "aladin1"),
//                Book(0, 1,"url", "aladin3", "writer", "summary", "aladin1"),
//                Book(0, 1,"url", "aladin4", "writer", "summary", "aladin1"),
//                Book(0, 1,"url", "aladin5", "writer", "summary", "aladin1")
//            )
//            Platform.YES24.yes24a -> listOf(
//                Book(0, 1,"url", "yes24a", "writer", "summary", "yes24a"),
//                Book(0, 1,"url", "yes24b", "writer", "summary", "yes24a"),
//                Book(0, 1,"url", "yes24c", "writer", "summary", "yes24a"),
//                Book(0, 1,"url", "yes24d", "writer", "summary", "yes24a"),
//                Book(0, 1,"url", "yes24e", "writer", "summary", "yes24a"),
//            )
//            else -> listOf()
//        }
//    )
}