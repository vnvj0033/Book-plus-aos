package com.vnvj0033.bookplus.push

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.vnvj0033.bookplus.R
import com.vnvj0033.bookplus.main.MainActivity

internal class PushNotificationManager {

    fun sendNotification(service: Service, title: String, body: String) {
        val intent = Intent(service, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) // 액티비티 중복 생성 방지
        }

        val pendingIntent = createPendingIntent(service, intent)

        val channelId = "DEFAULT_NOTIFICATION_CHANNEL_ID"
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION) // 소리

        val notification = NotificationCompat.Builder(service, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setDefaults(Notification.DEFAULT_SOUND)
            .build()

        val notificationManager =
            service.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // 오레오 버전 이후에는 채널이 필요
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, "Notice", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0, notification)
    }

    private fun createPendingIntent(context: Context, intent: Intent): PendingIntent {
        val pendingFlag = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ->
                PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT

            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ->
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT

            else ->
                PendingIntent.FLAG_UPDATE_CURRENT
        }

        return PendingIntent.getActivity(context, 0, intent, pendingFlag)
    }
}