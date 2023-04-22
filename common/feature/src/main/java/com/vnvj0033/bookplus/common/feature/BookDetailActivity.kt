package com.vnvj0033.bookplus.common.feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.vnvj0033.bookplus.data.model.MainBook
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailActivity : ComponentActivity() {
    companion object {
        private const val BUNDLE_KEY_NAME_BOOK = "BUNDLE_KEY_NAME_BOOK"

        fun startBookDetail(context: Context, book: MainBook) {
            val intent = Intent(context, BookDetailActivity::class.java)
            intent.putExtra(BUNDLE_KEY_NAME_BOOK, book)
            context.startActivity(intent)
        }
    }

    private val viewModel: BookDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BookDetailCompose()
        }

        intent.serializable<MainBook>(BUNDLE_KEY_NAME_BOOK)?.let { mainBook ->
            viewModel.setMainBook(mainBook)
        }
    }
}