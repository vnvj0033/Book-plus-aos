package com.vnvj0033.allinoneforcats

import android.app.Application
import com.vnvj0033.allinoneforcats.model.Data
import com.vnvj0033.allinoneforcats.push.FirebaseMessagingHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var data: Data
    }

    override fun onCreate() {
        super.onCreate()
        data = Data(applicationContext)

        FirebaseMessagingHelper.updateToken()
    }
}