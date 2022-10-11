package com.vnvj0033.allinoneforcats.di

import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailActivity
import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailEvent
import dagger.Component
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Component(dependencies = [CatEventDependencies::class])
interface CatDetailComponent {

    fun inject(activity: CatDetailActivity)

    @Component.Builder
    interface Builder {
        fun setEvent(catDetailEvent: CatEventDependencies): Builder
        fun build(): CatDetailComponent
    }
}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CatEventDependencies {
    fun catDetailEvent(): CatDetailEvent
}