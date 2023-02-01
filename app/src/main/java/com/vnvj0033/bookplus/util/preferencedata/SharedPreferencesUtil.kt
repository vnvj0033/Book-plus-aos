package com.vnvj0033.bookplus.util.preferencedata

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.appDataStore by preferencesDataStore(
    name = "AppPreferences"
)