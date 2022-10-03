package com.vnvj0033.allinoneforcats.di

import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailActivity
import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailEvent
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@DefineComponent(parent = SingletonComponent::class)
interface CatDetailComponent {

    fun inject(activity: CatDetailActivity)

    @DefineComponent.Builder
    interface CatDetailComponentBuilder {
        fun setEvent(@BindsInstance catDetailEvent: CatDetailEvent): CatDetailComponentBuilder
        fun build(): CatDetailComponent
    }
}

@EntryPoint
@InstallIn(CatDetailComponent::class)
interface CatDetailEventEntryPoint {
    fun inject(): CatDetailActivity
    fun putEvent(): CatDetailEvent
}