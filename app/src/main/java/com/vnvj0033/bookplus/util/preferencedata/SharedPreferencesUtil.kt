package com.vnvj0033.bookplus.util.preferencedata

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesUtil(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("preference_book_plus", Context.MODE_PRIVATE)

    fun getString(key: String, defValue: String) = prefs.getString(key, defValue)!!
    fun setString(key: String, str: String) = prefs.edit().putString(key, str).apply()

    fun getInt(key: String, defValue: Int) = prefs.getInt(key, defValue)
    fun setInt(key: String, str: Int) = prefs.edit().putInt(key, str).apply()
}