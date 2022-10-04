package com.vnvj0033.allinoneforcats.di

import com.vnvj0033.allinoneforcats.ui.userprofile.UserProfileEvent
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityComponent

@DefineComponent(parent = ActivityComponent::class)
interface UserProfileComponent {

    @DefineComponent.Builder
    interface UserProfileComponentBuilder {
        fun setEvent(@BindsInstance event: UserProfileEvent): UserProfileComponentBuilder
        fun build(): UserProfileComponent
    }
}
