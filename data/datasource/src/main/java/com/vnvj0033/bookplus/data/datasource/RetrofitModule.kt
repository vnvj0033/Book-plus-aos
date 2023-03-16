package com.vnvj0033.bookplus.data.datasource

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
    fun provideClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder().build()
                chain.run {
                    withConnectTimeout(10, TimeUnit.SECONDS)
                    withReadTimeout(10, TimeUnit.SECONDS)
                    withWriteTimeout(10, TimeUnit.SECONDS)
                    proceed(request)
                }
            }.build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://localhost:3000/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}