package com.vnvj0033.bookplus.data.repository.book

import com.vnvj0033.bookplus.data.model.Book
import javax.inject.Inject

class FakeBookRepository @Inject constructor() : BookRepository {
    override fun saveFavorite(userId: String, books: List<Book>): List<Book> {
        TODO("Not yet implemented")
    }

    override fun loadFavorite(userId: String): List<Book> {
        TODO("Not yet implemented")
    }

}