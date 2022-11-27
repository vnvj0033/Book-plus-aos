package com.vnvj0033.bookplus.data.datasouce.retrofit.api

import com.vnvj0033.bookplus.data.entry.CatEntry
import retrofit2.Call
import retrofit2.http.GET

interface CatApi {

    @GET("image/search")
    fun getCat(): Call<CatEntry>
}