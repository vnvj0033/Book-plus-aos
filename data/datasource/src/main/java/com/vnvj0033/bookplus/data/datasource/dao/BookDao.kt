package com.vnvj0033.bookplus.data.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vnvj0033.bookplus.data.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM Book")
    fun getAll(): Flow<List<Book>>

    @Insert
    fun insert(book: Book)

    @Query("DELETE FROM Book WHERE title=:title")
    fun delete(title: String)
}