package com.vnvj0033.allinoneforcats.data.datasouce.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vnvj0033.allinoneforcats.data.entry.Cat

@Database(entities = [Cat::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao
}