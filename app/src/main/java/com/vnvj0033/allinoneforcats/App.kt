package com.vnvj0033.allinoneforcats

import android.app.Application
import android.content.Context
import android.util.Log
import com.vnvj0033.allinoneforcats.db.CatDatabase
import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.push.FirebaseMessagingHelper
import com.vnvj0033.allinoneforcats.retrofit.RetrofitCore
import com.vnvj0033.allinoneforcats.retrofit.requester.CatRequester
import com.vnvj0033.allinoneforcats.util.data.PreferencesDataStore
import com.vnvj0033.allinoneforcats.util.data.SharedPreferencesData
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

//        loadDB()
        loadCat()
    }

    private fun loadCat() {
        val requester = CatRequester.getCat("cream")
        RetrofitCore.catApi.getCat(requester).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    response.body() ?: return

                    Log.d("retrofit", "isSuccessful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) { }

        })
    }

    private fun loadDB() {
        CoroutineScope(Dispatchers.IO).launch {
            CatDatabase.getInstance(context).catDao().addAll(Cat("1", "de", "im url"))
        }
    }
}