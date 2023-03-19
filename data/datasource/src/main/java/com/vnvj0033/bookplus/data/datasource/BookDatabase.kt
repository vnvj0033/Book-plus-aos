package com.vnvj0033.bookplus.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vnvj0033.bookplus.data.datasource.dao.BookDao
import com.vnvj0033.bookplus.data.model.Book

@Database(entities = [Book::class], version = 1)
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao
}