package com.vnvj0033.bookplus

import android.app.Application
import android.util.Log
import com.vnvj0033.bookplus.feature.push.FirebaseMessagingHelper
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@HiltAndroidApp
class App : Application() {

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate() {
        super.onCreate()

        val fcmHelper = EntryPoints.get(applicationContext, AppEntryPoints::class.java)
            .firebaseMessagingHelper

        GlobalScope.launch(CoroutineExceptionHandler{ c, t ->
            t.printStackTrace()
        }) {
            fcmHelper.updateToken()
        }
    }

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface AppEntryPoints {
        val firebaseMessagingHelper: FirebaseMessagingHelper
    }
}