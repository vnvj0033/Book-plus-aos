package com.vnvj0033.bookplus.util

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.StateFlow

class SavableMutableStateFlow<T>(
    private val savedStateHandle: SavedStateHandle,
    private val key: String,
    initialValue: T
) {
    private val state: StateFlow<T> = savedStateHandle.getStateFlow(key, initialValue)
    var value: T
        get() = state.value
        set(value) {
            savedStateHandle[key] = value
        }
    fun asStateFlow(): StateFlow<T> = state
}

fun <T> SavedStateHandle.getSavableMutableStateFlow(key: String, initialValue: T) =
    SavableMutableStateFlow(this, key, initialValue)