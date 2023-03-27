package com.vnvj0033.bookplus.data.repository.book

import com.vnvj0033.bookplus.data.model.Book

interface BookRepository {
    fun saveBookForId(userId: String, books: List<Book>)
    fun loadBookForId(userId: String): List<Book>

    fun loadBookForGenre(genre: String): List<Book>
}
