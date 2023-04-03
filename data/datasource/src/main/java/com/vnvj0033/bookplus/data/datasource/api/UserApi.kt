package com.vnvj0033.bookplus.data.datasource.api

import com.vnvj0033.bookplus.data.model.UserInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("/v1/user")
    fun loadUerInfo(@Query("user_id") userId: Int): Flow<UserInfo>
}