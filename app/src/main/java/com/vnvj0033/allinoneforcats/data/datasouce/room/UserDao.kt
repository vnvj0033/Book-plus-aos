package com.vnvj0033.allinoneforcats.data.datasouce.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vnvj0033.allinoneforcats.data.entry.CatEntry

@Dao
interface UserDao {
    @Query("select * from CatEntry")
    fun getFavoriteList(): List<CatEntry>

    @Insert
    fun insertCat(cat: CatEntry)
}
