package com.vnvj0033.allinoneforcats.common.di

import com.vnvj0033.allinoneforcats.presentation.view.userprofile.CatListAdapter
import com.vnvj0033.allinoneforcats.presentation.presenter.UserPresenter
import com.vnvj0033.allinoneforcats.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class UserProfileModule {

    @Provides
    fun providesRepository() = UserRepository()

    @Provides
    fun providesPresent(repository: UserRepository) = UserPresenter(repository)

    @Provides
    fun providesAdapter(presenter: UserPresenter) = CatListAdapter(presenter)

}
