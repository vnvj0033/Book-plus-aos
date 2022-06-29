package com.vnvj0033.allinoneforcats

import android.app.Application
import android.content.Context
import android.util.Log
import com.vnvj0033.allinoneforcats.util.data.SharedPreferencesData
import com.vnvj0033.allinoneforcats.util.data.PreferencesDataStore
import com.vnvj0033.allinoneforcats.push.FirebaseMessagingHelper
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var data: SharedPreferencesData
        lateinit var storeData: PreferencesDataStore
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        data = SharedPreferencesData(applicationContext)
        storeData = PreferencesDataStore(this@App)

        FirebaseMessagingHelper.updateToken()

        storeData.counter = flowOf("123")
        GlobalScope.launch {
            storeData.counter.collect {
                delay(100)
                Log.d("testsyyoo", it)
            }
            Log.d("testsyyoo", "end")
        }


    }
}