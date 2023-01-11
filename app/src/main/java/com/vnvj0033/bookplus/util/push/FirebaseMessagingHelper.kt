package com.vnvj0033.bookplus.util.push

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import com.google.firebase.messaging.FirebaseMessaging
import com.vnvj0033.bookplus.util.preferencedata.PreferenceKeys
import com.vnvj0033.bookplus.util.preferencedata.appDataStore
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

object FirebaseMessagingHelper {
    private val TAG = this::class.java.simpleName

    @OptIn(DelicateCoroutinesApi::class)
    fun updateToken(context: Context) = GlobalScope.launch {
        val dataStore = context.appDataStore

        dataStore.data.map { preferences ->
            preferences[PreferenceKeys.FCM_TOKEN] ?: ""
        }.collect { fcmToken ->
            if (fcmToken.isEmpty()) {
                FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        val token = task.result
                        GlobalScope.launch {
                            dataStore.edit {
                                it[PreferenceKeys.FCM_TOKEN] = token
                                Log.d(TAG, "updateToken : $token")
                            }
                        }
                    }
                }
            }
        }
    }
}