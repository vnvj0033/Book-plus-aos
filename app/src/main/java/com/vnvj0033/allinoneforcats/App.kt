package com.vnvj0033.allinoneforcats

import android.app.Application
import com.vnvj0033.allinoneforcats.util.push.FirebaseMessagingHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseMessagingHelper.updateToken()
    }
}