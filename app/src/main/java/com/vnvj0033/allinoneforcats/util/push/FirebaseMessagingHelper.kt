package com.vnvj0033.allinoneforcats.util.push

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.vnvj0033.allinoneforcats.App

object FirebaseMessagingHelper {
    private val TAG = this::class.java.simpleName

    fun updateToken() {
        val fcmToken = App.data.fcmToken
        if (fcmToken.isEmpty()) {

            FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    val token = task.result
                    App.data.fcmToken = token
                    Log.d(TAG, "updateToken : $token")
                } else {
                    Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                }
            }
        }
    }
}