package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entity.Book

interface BookRepository {
    val genres: List<String>
    val books: List<Book>

    fun updateGenre(platform: String)
    fun updateBooks(userId: String, genre: String): List<Book>
}
