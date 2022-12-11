package com.vnvj0033.bookplus.presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
                    imageVector = Icons.Default.Home,
                    contentDescription = null)
            },
            label = { Text("홈") })

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null) },
            label = { Text("선호 장르") })


        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null) },
            label = { Text("구독하기") })

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null) },
            label = { Text("설정") })
    }
}


@Preview
@Composable
private fun Preview() {
    AppTheme {
        BottomNavigation()
    }
}