package com.vnvj0033.bookplus.data.datasouce.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vnvj0033.bookplus.data.entry.CatEntry

@Database(entities = [CatEntry::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao
}