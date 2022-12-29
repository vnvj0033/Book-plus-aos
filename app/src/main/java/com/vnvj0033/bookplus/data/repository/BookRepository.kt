package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entity.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class BookRepositoryImpl : BookRepository {

    override val genres: Flow<List<String>>
        get() = flowOf(listOf("전체", "문학 작품", "국내 소설", "컴퓨터/IT", "취미/생활"))

    override val books: Flow<List<Book>>
        get() = flowOf(listOf( Book()))


    override suspend fun loadFavoriteBooks(userId: String, genre: String): Flow<List<Book>> {
        return flowOf(listOf( Book()))
    }

}

interface BookRepository {
    val genres: Flow<List<String>>
    val books: Flow<List<Book>>

    suspend fun loadFavoriteBooks(userId: String, genre: String): Flow<List<Book>>
}
