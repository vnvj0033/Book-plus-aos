package com.vnvj0033.bookplus.ui.subscript

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.GenreToggleList
import com.vnvj0033.bookplus.ui.PlatformSelectionList

@Composable
fun SubscriptCompose() {
    SubscriptCompose("123")
    
}

@Composable
private fun SubscriptCompose(name: String) {

    val selectedList = remember {
        arrayListOf<String>()
    }

    Column(Modifier.fillMaxHeight()) {
        PlatformSelectionList { platform ->
            if (selectedList.contains(platform)) {
                selectedList.remove(platform)
            } else {
                selectedList.add(platform)
            }
        }

        GenreToggleList(
            options = listOf(
                "abc",
                "bdds",
                "abc123",
                "baasddds",
                "오나라라",
                "오나라라ㅏ라",
                "아주나라라라",
                "동해물과백두산이마르고닭도록하느님이보우하사우리나라만세무궁화삼천리화려강산",
                "대한사람 대한으로 길이보전하세"
            ),
            selectedList = selectedList
        )

    }

}

@Composable
@Preview
private fun Preview() {
    AppTheme {
        SubscriptCompose("")
    }
}