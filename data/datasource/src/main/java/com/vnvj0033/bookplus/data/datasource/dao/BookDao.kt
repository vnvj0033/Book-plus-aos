package com.vnvj0033.bookplus.data.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vnvj0033.bookplus.data.model.Book

@Dao
interface BookDao {

    @Query("SELECT * FROM Book")
    fun getAll(): List<Book>

    @Insert
    fun insert(book: Book)

    @Query("DELETE FROM Book WHERE title=:title")
    fun delete(title: String)
}