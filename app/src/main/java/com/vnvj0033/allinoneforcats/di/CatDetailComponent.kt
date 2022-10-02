package com.vnvj0033.allinoneforcats.di

import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailActivity
import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailEvent
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@Component(dependencies = [CatDetailEventEntryPoint::class])
interface CatDetailComponent {

    fun inject(activity: CatDetailActivity)

    @Component.Builder
    interface CatDetailComponentBuilder {
        fun setCatDetailEvent(@BindsInstance catDetailEvent: CatDetailEvent): CatDetailComponent
        fun build(): CatDetailComponent
    }
}

@EntryPoint
@InstallIn(CatDetailComponent::class)
interface CatDetailEventEntryPoint {
    fun getEvent(): CatDetailEvent
}