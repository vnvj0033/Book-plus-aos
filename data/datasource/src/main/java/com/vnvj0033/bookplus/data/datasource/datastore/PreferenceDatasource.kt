package com.vnvj0033.bookplus.data.datasource.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import javax.inject.Inject

class PreferenceDatasource @Inject constructor(
    dataStore: DataStore<Preferences>
) {
    val fcmTokenWrapper = dataStore.wrapper(
        PreferenceKeys.FCM_TOKEN,
        ""
    )

}

