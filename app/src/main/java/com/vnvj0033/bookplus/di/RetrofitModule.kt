package com.vnvj0033.bookplus.di

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

    @Provides
    @Singleton
    fun provideClient() =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder().build()
                chain.run {
                    withConnectTimeout(10, TimeUnit.SECONDS)
                    withReadTimeout(10, TimeUnit.SECONDS)
                    withWriteTimeout(10, TimeUnit.SECONDS)
                }
                chain.proceed(request)
            }.build()

    // 레트로핏 객체
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl("https://localhost:3000/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}