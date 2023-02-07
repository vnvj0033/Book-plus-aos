package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entity.Book
import javax.inject.Inject

class FakeBookRepo @Inject constructor() : BookRepository {
    override var genres: List<String> = listOf()
    override var books: List<Book> = listOf()

    override fun updateGenre(platform: String) = when (platform) {
        "kyobo" -> listOf("kyobo", "kyobo2", "kyobo3", "kyobo4", "kyobo5", "kyobo6", "kyobo7", "kyobo8")
        "yes24" -> listOf("yes24a", "yes24b", "yes24c", "yes24d", "yes24e", "yes24f", "yes24g", "yes24h")
        "aladin" -> listOf("aladin1", "aladin2", "aladin3", "aladin4", "aladin5", "aladin6", "aladin7", "aladin8")
        else -> listOf("1", "2", "3", "4", "5", "6", "7", "8")
    }

    override fun updateBooks(userId: String, genre: String): List<Book> = when (genre) {
        "1" -> listOf(Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book())
        "2", "3" -> listOf(Book(), Book(), Book())
        else -> listOf(Book())
    }
}