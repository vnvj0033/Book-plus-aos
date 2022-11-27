package com.vnvj0033.bookplus.di

import android.content.Context
import androidx.room.Room
import com.vnvj0033.bookplus.data.datasouce.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideUserDatabase(@ActivityContext context: Context) =
        Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "cat").build()

    @Singleton
    @Provides
    fun provideUserDao(userDatabase: UserDatabase) = userDatabase.userDao
}