package com.vnvj0033.bookplus.data.repository.book

import com.vnvj0033.bookplus.data.model.Book
import com.vnvj0033.bookplus.data.model.Platform
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun sendBookForId(userId: String, books: List<Book>)
    fun fetchBookForId(userId: String): Flow<List<Book>>

    suspend fun fetchBookForGenre(genre: Platform.Genre): Flow<List<Book>>
}
