package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entity.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.*
import javax.inject.Inject

class FakeBookRepo @Inject constructor() : BookRepository {
    override suspend fun loadFavoriteBooks(userId: String, genre: String): Flow<List<Book>> {
        val list = if (genre == "1") {
            listOf(Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book())
        } else if (genre == "2" || genre == "3") {
            listOf(Book(), Book(), Book())
        } else {
            listOf(Book())
        }

        return flowOf(list)
    }

    override suspend fun loadBooks(platform: String, genre: String): Flow<List<Book>> {
        val list = if (genre == "전체") {
            listOf(Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book(), Book())
        } else if (genre == "문학" || genre == "문학 작품") {
            listOf(Book(), Book(), Book())
        } else {
            listOf(Book())
        }

        return flowOf(list)
    }

    override suspend fun loadGenres(platform: String): Flow<List<String>> {
        val list = if (platform.uppercase(Locale.getDefault()) == "KYOBO") {
            listOf("전체", "문학 작품", "국내 소설", "컴퓨터/IT", "취미/생활")
        } else if (platform.uppercase(Locale.getDefault()) == "YES24") {
            listOf("전체", "문학", "소설", "동화")
        } else if (platform.uppercase(Locale.getDefault()) == "ALADIN") {
            listOf("전체", "부동산", "경제", "취미", "예술", "취업", "먹거리")
        } else {
            listOf()
        }


        return flowOf(list)
    }
}