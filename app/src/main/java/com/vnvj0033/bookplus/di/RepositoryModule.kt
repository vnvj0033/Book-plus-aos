package com.vnvj0033.bookplus.di

import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.data.repository.FakeBookRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindBookRepo(repository: FakeBookRepo): BookRepository
}