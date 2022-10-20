package com.vnvj0033.allinoneforcats.common.di

import com.vnvj0033.allinoneforcats.presentation.presenter.CatDetailPresent
import com.vnvj0033.allinoneforcats.data.repository.CatDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class CatDetailModule {

    @Provides
    fun providesRepository() = CatDetailRepository()

    @Provides
    fun providesPresent(repository: CatDetailRepository) = CatDetailPresent(repository)


}
