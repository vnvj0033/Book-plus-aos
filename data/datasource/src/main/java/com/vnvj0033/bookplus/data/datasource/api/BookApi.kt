package com.vnvj0033.bookplus.data.datasource.api

import com.vnvj0033.bookplus.data.model.Book
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    @GET("/books")
    suspend fun getBooks(@Query("platform") platform: String): List<Book>
}