package com.vnvj0033.allinoneforcats

import android.app.Application
import android.util.Log
import com.vnvj0033.allinoneforcats.model.Data
import com.vnvj0033.allinoneforcats.model.DataStore
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
        lateinit var data: Data
        lateinit var storeData: DataStore
    }

    override fun onCreate() {
        super.onCreate()
        data = Data(applicationContext)
        storeData = DataStore(this@App)

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