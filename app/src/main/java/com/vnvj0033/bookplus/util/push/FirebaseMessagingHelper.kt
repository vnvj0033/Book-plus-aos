package com.vnvj0033.bookplus.util.push

import android.content.Context
import com.google.firebase.messaging.FirebaseMessaging
import com.vnvj0033.bookplus.util.preferencedata.PreferenceDatasource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FirebaseMessagingHelper(context: Context) {
    private val preferencesDatasource = PreferenceDatasource(context)

    @OptIn(DelicateCoroutinesApi::class)
    fun updateToken() {
        GlobalScope.launch {
            val token = preferencesDatasource.loadFcmToken()

            if (token.isEmpty()) {
                FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        GlobalScope.launch {
                            preferencesDatasource.saveFcmToken(task.result)
                        }
                    }
                }
            }
        }
    }
}