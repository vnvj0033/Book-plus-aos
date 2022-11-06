package com.vnvj0033.allinoneforcats.di

import com.vnvj0033.allinoneforcats.data.datasouce.retrofit.api.CatApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {
    // OkHttp client
    @Singleton
    @Provides
    fun provideClient() = OkHttpClient.Builder()
//        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }) // debugging 용도 로그 노출
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .build()

            chain.run {
                withConnectTimeout(10, TimeUnit.SECONDS)
                withReadTimeout(10, TimeUnit.SECONDS)
                withWriteTimeout(10, TimeUnit.SECONDS)
            }

            chain.proceed(request)
        }.build()

    // 레트로핏 객체
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideCatApi(retrofit: Retrofit) = retrofit.create(CatApi::class.java)

}