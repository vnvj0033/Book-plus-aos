package com.vnvj0033.bookplus.ui.bookdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vnvj0033.bookplus.domain.model.MainBook
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailActivity : ComponentActivity() {
    companion object {
        private const val BUNDLE_KEY_NAME_BOOK = "bundle_key_name_book"

        fun openBookDetail(context: Context, book: MainBook) {
            val intent = Intent(context, BookDetailActivity::class.java)
            intent.putExtra(BUNDLE_KEY_NAME_BOOK, book)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BookDetailCompose()
        }
    }
}