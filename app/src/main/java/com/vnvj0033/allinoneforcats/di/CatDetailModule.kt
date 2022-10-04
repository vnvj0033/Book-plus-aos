package com.vnvj0033.allinoneforcats.di

import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailAdapter
import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailEvent
import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailPresent
import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(CatDetailComponent::class)
class CatDetailModule {

    @Provides
    fun providesRepository() = CatDetailRepository()

    @Provides
    fun providesPresent(event: CatDetailEvent, repository: CatDetailRepository) = CatDetailPresent(event, repository)

    @Provides
    fun providesCatDetailAdapter(event: CatDetailEvent) = CatDetailAdapter(event)

}
