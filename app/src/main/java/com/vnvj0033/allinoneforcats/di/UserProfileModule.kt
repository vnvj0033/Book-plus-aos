package com.vnvj0033.allinoneforcats.di

import com.vnvj0033.allinoneforcats.ui.userprofile.CatListAdapter
import com.vnvj0033.allinoneforcats.ui.userprofile.UserPresenter
import com.vnvj0033.allinoneforcats.ui.userprofile.UserProfileEvent
import com.vnvj0033.allinoneforcats.ui.userprofile.UserRepository
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
    fun providesPresent(event: UserProfileEvent, repository: UserRepository) = UserPresenter(event, repository)

    @Provides
    fun providesAdapter(presenter: UserPresenter) = CatListAdapter(presenter)

}
