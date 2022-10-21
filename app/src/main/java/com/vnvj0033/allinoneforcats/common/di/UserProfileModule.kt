package com.vnvj0033.allinoneforcats.common.di

import android.content.Context
import com.vnvj0033.allinoneforcats.presentation.view.userprofile.CatListAdapter
import com.vnvj0033.allinoneforcats.presentation.presenter.UserPresenter
import com.vnvj0033.allinoneforcats.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
class UserProfileModule {

    @InUserProfile
    @Provides
    fun providesRepository(@ApplicationContext context: Context) = UserRepository(context)

    @InUserProfile
    @Provides
    fun providesPresent(repository: UserRepository) = UserPresenter(repository)

    @InUserProfile
    @Provides
    fun providesAdapter() = CatListAdapter()
}

@Qualifier
annotation class InUserProfile
