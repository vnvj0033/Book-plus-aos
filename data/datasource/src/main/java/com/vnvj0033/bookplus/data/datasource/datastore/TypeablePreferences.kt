package com.vnvj0033.bookplus.data.datasource.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single

class TypeablePreferences<T>(
    context: Context,
    private val key: Preferences.Key<T>,
    private val initValue: T
) {
    private val datastore: DataStore<Preferences> = context.appDataStore

    suspend fun loadValue() = datastore.data.map { preferences ->
        preferences[key] ?: initValue
    }.single()

    suspend fun saveValue(value: T) {
        datastore.edit {
            it[key] = value
        }
    }
}

fun <T> Context.typeablePreferences(
    key: Preferences.Key<T>,
    initValue: T
) = TypeablePreferences(this, key, initValue)

private val Context.appDataStore by preferencesDataStore(
    name = "AppPreferences"
)