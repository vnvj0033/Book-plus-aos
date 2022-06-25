package com.vnvj0033.allinoneforcats.model

import com.vnvj0033.allinoneforcats.App
import com.vnvj0033.allinoneforcats.util.DataStoreUtil
import kotlinx.coroutines.flow.Flow

class DataStore(app: App) {
    var shared = DataStoreUtil(app)

    var counter: Flow<String>
        get() = shared.getString("TEST")
        set(value) = shared.inputString("TEST", value)

}