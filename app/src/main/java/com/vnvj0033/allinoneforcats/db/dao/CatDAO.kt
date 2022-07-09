package com.vnvj0033.allinoneforcats.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vnvj0033.allinoneforcats.model.Cat

@Dao
interface CatDAO {
    @Insert
    fun addAll(vararg cat: Cat)

    @Delete
    fun delete(cat: Cat)

    @Query("SELECT * FROM cat")
    fun getAll(): List<Cat>

    @Query("SELECT * FROM cat WHERE name = :name")
    fun getCat(name: String): Cat?
}