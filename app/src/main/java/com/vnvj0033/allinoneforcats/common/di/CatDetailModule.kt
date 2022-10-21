package com.vnvj0033.allinoneforcats.common.di

import com.vnvj0033.allinoneforcats.presentation.presenter.CatDetailPresent
import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.presentation.view.catdetail.CatDetailAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
class CatDetailModule {

    @InCatDetail
    @Provides
    fun providesRepository() = CatRepository()

    @InCatDetail
    @Provides
    fun providesPresent(repository: CatRepository) = CatDetailPresent(repository)

    @InCatDetail
    @Provides
    fun providesAdapter() = CatDetailAdapter()
}

@Qualifier
annotation class InCatDetail
