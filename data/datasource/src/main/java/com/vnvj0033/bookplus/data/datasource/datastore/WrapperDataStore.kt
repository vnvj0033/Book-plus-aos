package com.vnvj0033.bookplus.data.datasource.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class WrapperDataStore <T> (
    private val dataStore: DataStore<Preferences>,
    private val key: Preferences.Key<T>,
    private val initValue: T
) {
    suspend fun loadData() =
        dataStore.data.map {
            it[key] ?: initValue
        }.first()

    suspend fun saveData(value: T) {
        dataStore.edit { it[key] = value }
    }
}

internal fun <T> DataStore<Preferences>.wrapper(
    key: Preferences.Key<T>,
    initValue: T
) = WrapperDataStore(this, key, initValue)
