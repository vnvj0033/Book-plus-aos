package com.vnvj0033.bookplus.data.datasource.di

import android.content.Context
import androidx.room.Room
import com.vnvj0033.bookplus.data.datasource.BookDatabase
import com.vnvj0033.bookplus.data.datasource.dao.BookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideBookDatabase(@ApplicationContext context: Context): BookDatabase =
        Room.databaseBuilder(context, BookDatabase::class.java, "book_database")
            .build()

    @Provides
    @Singleton
    fun provideBookDao(database: BookDatabase): BookDao =
        database.bookDao()
}