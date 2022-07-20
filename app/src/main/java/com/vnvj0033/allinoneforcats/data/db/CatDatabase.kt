package com.vnvj0033.allinoneforcats.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vnvj0033.allinoneforcats.data.db.dao.CatDAO
import com.vnvj0033.allinoneforcats.model.Cat

@Database(entities = [Cat::class], version = 1)
abstract class CatDatabase: RoomDatabase() {
    abstract fun catDao(): CatDAO

    companion object {
        private var instance: CatDatabase? = null

        @Synchronized
        fun getInstance(context: Context): CatDatabase {
            if (instance == null) {
                synchronized(CatDatabase::class){
                    instance = Room.databaseBuilder(context, CatDatabase::class.java, "cat_database").build()
                }
            }
            return instance ?: throw Exception("instance is not be null")
        }
    }
}