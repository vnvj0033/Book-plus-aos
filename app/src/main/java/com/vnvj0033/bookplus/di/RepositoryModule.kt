package com.vnvj0033.bookplus.di

import com.example.repository.BookRepository
import com.example.repository.FakeBookRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindBookRepo(repository: com.example.repository.FakeBookRepo): com.example.repository.BookRepository
}