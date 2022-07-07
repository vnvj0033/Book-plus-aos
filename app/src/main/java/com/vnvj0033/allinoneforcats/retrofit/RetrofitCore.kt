package com.vnvj0033.allinoneforcats.retrofit

import com.vnvj0033.allinoneforcats.retrofit.api.CatApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitCore {

    // OkHttp client
    private val client = OkHttpClient.Builder()
//        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }) // debugging 용도 로그 노출
        .build()

    // 레트로핏 객체
    private val retrofit = Retrofit.Builder()
        .baseUrl("")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 통신 API 인터페이스 구현
    val catApi: CatApi = retrofit.create(CatApi::class.java)
}