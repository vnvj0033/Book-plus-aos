package com.vnvj0033.allinoneforcats.model

import android.content.Context
import com.vnvj0033.allinoneforcats.util.PreferenceUtil

class Data(context: Context) {
    var shared = PreferenceUtil(context)

    var fcmToken: String
        get() = shared.getString("FCM_TOKEN", "")
        set(value) = shared.setString("FCM_TOKEN", value)

}