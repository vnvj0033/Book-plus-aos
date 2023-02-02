package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entity.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    val genres: Flow<List<String>>
    val books: Flow<List<Book>>

    fun updateGenre(platform: String)

    suspend fun loadFavoriteBooks(userId: String, genre: String): Flow<List<Book>>
}
