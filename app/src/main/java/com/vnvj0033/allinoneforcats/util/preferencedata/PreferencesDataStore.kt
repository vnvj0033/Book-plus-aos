package com.vnvj0033.allinoneforcats.util.preferencedata

import com.vnvj0033.allinoneforcats.App
import kotlinx.coroutines.flow.Flow

class PreferencesDataStore(app: App) {
    var shared = DataStoreUtil(app)

    var counter: Flow<String>
        get() = shared.getString("TEST")
        set(value) = shared.inputString("TEST", value)

}