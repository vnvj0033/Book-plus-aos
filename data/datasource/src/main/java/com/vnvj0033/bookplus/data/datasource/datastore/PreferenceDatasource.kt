package com.vnvj0033.bookplus.data.datasource.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class PreferenceDatasource @Inject constructor(
    @ApplicationContext context: Context
) {
    private val datastore = context.appDataStore

    suspend fun loadFcmToken(): String {
        return datastore.data.map { preferences ->
            preferences[PreferenceKeys.FCM_TOKEN] ?: ""
        }.single()
    }


    suspend fun saveFcmToken(token: String) {
        datastore.edit {
            it[PreferenceKeys.FCM_TOKEN] = token
        }
    }
}