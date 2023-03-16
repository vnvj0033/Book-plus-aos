package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.model.Book
import com.vnvj0033.bookplus.data.model.Constant
import javax.inject.Inject

class FakeBookRepo @Inject constructor() : BookRepository {
    override var genres: List<String> = listOf()
    override var books: List<Book> = listOf()

    override fun loadGenreForPlatform(platform: String) = when (platform) {
        Constant.Platform.KYOBO -> listOf("kyobo1", "kyobo2", "kyobo3", "kyobo4", "kyobo5", "kyobo6", "kyobo7", "kyobo8")
        Constant.Platform.YES24 -> listOf("yes24a", "yes24b", "yes24c", "yes24d", "yes24e", "yes24f", "yes24g", "yes24h")
        Constant.Platform.ALADIN -> listOf("aladin1", "aladin2", "aladin3", "aladin4", "aladin5", "aladin6", "aladin7", "aladin8")
        else -> listOf("1", "2", "3", "4", "5", "6", "7", "8")
    }

    override fun loadGenreForUserId(userId: String): List<String> {
        return loadGenreForPlatform(Constant.Platform.KYOBO)
    }

    override fun loadBooksForGenre(genre: String): List<Book> =
        if (genre.contains("1")) {
            listOf(Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book())
        } else if (genre.contains("2") || genre.contains("3")) {
            listOf(Book(), Book(), Book())
        } else {
            listOf(Book())
        }

    override fun loadBooksForUserId(userId: String): List<Book> {
        return loadBooksForGenre("1")
    }

}