package com.vnvj0033.bookplus.data.repository.book

import com.vnvj0033.bookplus.data.model.Book
import javax.inject.Inject

class FakeBookRepository @Inject constructor() : BookRepository {
    private val userDb = hashMapOf<String, List<Book>>()

    override fun saveFavorite(userId: String, books: List<Book>) {
        userDb[userId] = books
    }

    override fun loadFavorite(userId: String): List<Book> =
        userDb[userId] ?: emptyList()

}