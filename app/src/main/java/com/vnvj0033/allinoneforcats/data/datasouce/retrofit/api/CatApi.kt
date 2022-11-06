package com.vnvj0033.allinoneforcats.data.datasouce.retrofit.api

import com.vnvj0033.allinoneforcats.data.entry.CatEntry
import retrofit2.Call
import retrofit2.http.GET

interface CatApi {

    @GET("image/search")
    fun getCat(): Call<CatEntry>
}