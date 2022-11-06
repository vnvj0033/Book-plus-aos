package com.vnvj0033.allinoneforcats.data.datasouce.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vnvj0033.allinoneforcats.data.entry.Cat
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("select * from cat")
    fun getFavoriteList(): Flow<List<Cat>>

    @Insert
    fun insertCat(cat: Cat)
}
