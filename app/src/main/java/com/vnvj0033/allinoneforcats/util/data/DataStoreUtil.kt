package com.vnvj0033.allinoneforcats.util.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.vnvj0033.allinoneforcats.App
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DataStoreUtil(private val app: App) {

    private val App.dataStore: DataStore<Preferences> by preferencesDataStore(name = "datastore_all_in_one_cat")


    // read
    fun getString(key: String): Flow<String> = app.dataStore.data
        .map { preferences ->
            // No type safety.
            preferences[stringPreferencesKey(key)] ?: ""
        }

    // write
    fun inputString(key: String, value: Flow<String>) {
        GlobalScope.launch {
            app.dataStore.edit { settings ->
                settings[stringPreferencesKey(key)] = value.first()
            }
        }
    }

}