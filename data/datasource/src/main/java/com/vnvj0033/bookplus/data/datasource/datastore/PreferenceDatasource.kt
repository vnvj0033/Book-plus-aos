package com.vnvj0033.bookplus.data.datasource.datastore

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferenceDatasource @Inject constructor(
    @ApplicationContext context: Context
) {
    private var fcmToken = context.typeablePreferences(PreferenceKeys.FCM_TOKEN, "")
    
    suspend fun loadFcmToken(): String = fcmToken.loadValue()
    
    suspend fun saveFcmToken(token: String) {
        fcmToken.saveValue(token)
    }
}