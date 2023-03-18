package com.vnvj0033.bookplus.data.repository.book

import com.vnvj0033.bookplus.data.model.Book

interface BookRepository {
    fun saveFavorite(userId: String, books: List<Book>)
    fun loadFavorite(userId: String): List<Book>
}
