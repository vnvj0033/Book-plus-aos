package com.vnvj0033.allinoneforcats.di

import com.vnvj0033.allinoneforcats.ui.catdetil.CatDetailEvent
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityComponent

@DefineComponent(parent = ActivityComponent::class)
interface CatDetailComponent {

    @DefineComponent.Builder
    interface CatDetailComponentBuilder {
        fun setEvent(@BindsInstance catDetailEvent: CatDetailEvent): CatDetailComponentBuilder
        fun build(): CatDetailComponent
    }
}
