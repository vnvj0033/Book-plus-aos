package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entity.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class BookRepositoryImpl : BookRepository {
    override suspend fun loadBooks(genre: String): Flow<List<Book>> {
        return flowOf(listOf( Book()))
    }

    override suspend fun loadBooks(platform: String, genre: String): Flow<List<Book>> {
        return flowOf(listOf( Book()))
    }

    override suspend fun loadGenres(): Flow<List<String>> {
        val list = listOf("전체", "문학 작품", "국내 소설", "컴퓨터/IT", "취미/생활")
        return flowOf(list)
    }

}

interface BookRepository {
    suspend fun loadBooks(genre: String): Flow<List<Book>>
    suspend fun loadBooks(platform: String, genre: String): Flow<List<Book>>
    suspend fun loadGenres(): Flow<List<String>>
}
