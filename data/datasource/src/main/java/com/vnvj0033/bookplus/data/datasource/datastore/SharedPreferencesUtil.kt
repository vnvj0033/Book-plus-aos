package com.vnvj0033.bookplus.data.datasource.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.appDataStore by preferencesDataStore(
    name = "AppPreferences"
)