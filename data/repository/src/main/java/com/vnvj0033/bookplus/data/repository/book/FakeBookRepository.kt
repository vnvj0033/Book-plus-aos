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

    override suspend fun fetchBookForGenre(genre: Platform.Genre): Flow<List<Book>> {
        var platform = Platform.platforms().first()
        Platform.platforms().forEach {
            if (it.genres().contains(genre)) {
                platform = it
                return@forEach
            }
        }
        return flowOf(bookApi.getBooks(platform.name().lowercase()))
    }
}