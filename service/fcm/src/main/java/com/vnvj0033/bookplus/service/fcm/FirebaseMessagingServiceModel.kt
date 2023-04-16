package com.vnvj0033.bookplus.service.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.vnvj0033.bookplus.data.datasource.datastore.PreferenceDatasource
import javax.inject.Inject

class FirebaseMessagingServiceModel @Inject constructor(
    preferenceDatasource: PreferenceDatasource
) {
    companion object {
        private const val TAG = "FirebaseMessagingHelper"
    }

    private val fcmDataStore = preferenceDatasource.fcmTokenWrapper

    suspend fun updateToken() {
        Log.d(TAG, "check token of fcm")
        val token = fcmDataStore.loadData()

        if (token.isEmpty()) {
            Log.d(TAG, "create new token")
            FirebaseMessaging.getInstance().token.result?.let { newToken ->
                fcmDataStore.saveData(newToken)
            }
        } else {
            Log.d(TAG, "app has token")
        }
    }
}