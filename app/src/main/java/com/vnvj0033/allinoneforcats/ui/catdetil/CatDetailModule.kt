package com.vnvj0033.allinoneforcats.ui.catdetil

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

    @Provides
    fun providesCatDetailAdapter() = CatDetailAdapter()

}
