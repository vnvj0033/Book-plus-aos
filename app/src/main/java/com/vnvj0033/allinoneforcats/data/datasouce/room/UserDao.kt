package com.vnvj0033.allinoneforcats.data.datasouce.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vnvj0033.allinoneforcats.domain.model.DetailCat
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("select * from DetailCat")
    fun getFavoriteList(): Flow<List<DetailCat>>

    @Insert
    fun insertCat(cat: DetailCat)
}
