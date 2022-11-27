package com.vnvj0033.bookplus

import android.app.Application
import com.vnvj0033.bookplus.util.preferencedata.SharedPreferencesData
import com.vnvj0033.bookplus.util.push.FirebaseMessagingHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var data: SharedPreferencesData
    }

    override fun onCreate() {
        super.onCreate()
        data = SharedPreferencesData(applicationContext)
        FirebaseMessagingHelper.updateToken()
    }
}