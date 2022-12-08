package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entity.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeBookRepo : BookRepository {
    override suspend fun loadBook(genre: String): Flow<Book> {
        return flowOf(Book())
    }

    override suspend fun loadGenres(): Flow<List<String>> {
        val list = listOf("전체", "문학 작품", "국내 소설", "컴퓨터/IT", "취미/생활")
        return flowOf(list)
    }

}

interface BookRepository {
    suspend fun loadBook(genre: String): Flow<Book>
    suspend fun loadGenres(): Flow<List<String>>
}
