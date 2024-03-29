package com.vnvj0033.bookplus.push

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class BookPlusFirebaseMessagingService : FirebaseMessagingService() {
    companion object {
        private val TAG = BookPlusFirebaseMessagingService::class.java.simpleName
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        FirebaseMessaging.getInstance().subscribeToTopic("all")

        Log.d(TAG, "onNewToken : $token")
    }


    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val title = message.data["title"] ?: ""
        val body = message.data["body"] ?: ""

        PushNotificationManager().sendNotification(this, title, body)
    }

}