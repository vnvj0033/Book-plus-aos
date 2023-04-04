package com.vnvj0033.bookplus.navigate

import android.content.Context
import com.vnvj0033.bookplus.data.model.MainBook
import com.vnvj0033.bookplus.feature.detail.BookDetailActivity

object Navigator {

    fun openDetailActivity(context: Context,mainBook: MainBook) {
        BookDetailActivity.openBookDetail(context, mainBook)
    }
}