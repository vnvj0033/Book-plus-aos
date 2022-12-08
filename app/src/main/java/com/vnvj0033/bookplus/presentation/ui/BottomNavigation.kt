package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigation() {

    BottomAppBar {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null)
            },
            label = {
                Text("메인")
            })

        NavigationBarItem(selected = false, onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null)
            },
            label = {
                Text("선호 장르")
            })

        NavigationBarItem(selected = false, onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null)
            },
            label = {
                Text("설정")
            })
    }
}


@Preview
@Composable
private fun Preview() {
    AppTheme {
        BottomNavigation()
    }
}