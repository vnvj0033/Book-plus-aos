package com.vnvj0033.bookplus.feature.push

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.vnvj0033.bookplus.data.datasource.datastore.PreferenceDatasource
import javax.inject.Inject

class FirebaseMessagingHelper @Inject constructor(
    preferenceDatasource: PreferenceDatasource
) {
    private val fcmDataStore = preferenceDatasource.fcmTokenWrapper

    suspend fun updateToken() {
        Log.d("testsyyoo", "run updateToken")
        val token = fcmDataStore.loadData()

        if (token.isEmpty()) {
            Log.d("testsyyoo", "token is empty")
            FirebaseMessaging.getInstance().token.result?.let { newToken ->
                Log.d("testsyyoo", "new token : $newToken")
                fcmDataStore.saveData(newToken)
            }
        } else {
            Log.d("testsyyoo", "has token")
        }
    }
}