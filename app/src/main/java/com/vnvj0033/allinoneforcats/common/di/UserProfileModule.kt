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

@Module
@InstallIn(ActivityComponent::class)
class UserProfileModule {

    @Provides
    fun providesRepository(@ApplicationContext context: Context) = UserRepository(context)

    @Provides
    fun providesPresent(repository: UserRepository) = UserPresenter(repository)

    @Provides
    fun providesAdapter(presenter: UserPresenter) = CatListAdapter(presenter)

}
