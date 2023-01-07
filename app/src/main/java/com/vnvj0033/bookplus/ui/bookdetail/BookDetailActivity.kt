package com.vnvj0033.bookplus.ui.bookdetail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailActivity : ComponentActivity() {
    companion object {
        const val BUNDLE_KEY_NAME_BOOK = "bundle_key_name_book"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { }
    }
}