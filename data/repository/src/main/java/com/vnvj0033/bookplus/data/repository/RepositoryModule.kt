package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.repository.book.BookRepository
import com.vnvj0033.bookplus.data.repository.book.FakeBookRepository
import com.vnvj0033.bookplus.data.repository.genre.FakeGenreRepository
import com.vnvj0033.bookplus.data.repository.genre.GenreRepository
import com.vnvj0033.bookplus.data.repository.user.FakeUserRepository
import com.vnvj0033.bookplus.data.repository.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindBookRepo(repository: FakeBookRepository): BookRepository

    @Binds
    abstract fun bindUserRepo(repository: FakeUserRepository): UserRepository

    @Binds
    abstract fun bindGenreRepo(repository: FakeGenreRepository): GenreRepository
}