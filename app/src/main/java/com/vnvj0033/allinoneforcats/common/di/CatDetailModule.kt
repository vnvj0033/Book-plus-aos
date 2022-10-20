package com.vnvj0033.allinoneforcats.common.di

import com.vnvj0033.allinoneforcats.presentation.presenter.CatDetailPresent
import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.presentation.view.catdetail.CatDetailAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class CatDetailModule {

    @Provides
    fun providesRepository() = CatRepository()

    @Provides
    fun providesPresent(repository: CatRepository) = CatDetailPresent(repository)

    @Provides
    fun providesAdapter() = CatDetailAdapter()

}
