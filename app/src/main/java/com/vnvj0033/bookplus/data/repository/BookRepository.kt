package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entity.Book

interface BookRepository {
    val genres: List<String>
    val books: List<Book>

    fun loadGenreForPlatform(platform: String): List<String>
    fun loadGenreForUserId(userId: String): List<String>
    fun loadBooksForGenre(genre: String): List<Book>
    fun loadBooksForUserId(userId: String): List<Book>
}
