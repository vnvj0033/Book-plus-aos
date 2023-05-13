package com.vnvj0033.bookplus.data.datasource.api

import com.vnvj0033.bookplus.data.model.Book
import com.vnvj0033.bookplus.data.model.Platform
import com.vnvj0033.bookplus.data.model.UserInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    @GET("/books")
    fun getBooks(@Query("platform") platform: String): Flow<List<Book>>
}