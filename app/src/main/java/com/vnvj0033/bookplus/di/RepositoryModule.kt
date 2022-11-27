package com.vnvj0033.bookplus.di

import com.vnvj0033.bookplus.data.repository.CatRepository
import com.vnvj0033.bookplus.data.repository.FakeCatRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCatRepository(model: FakeCatRepo): CatRepository
}