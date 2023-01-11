package com.vnvj0033.bookplus

import android.app.Application
import com.vnvj0033.bookplus.util.push.FirebaseMessagingHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseMessagingHelper.updateToken(applicationContext)
    }
}