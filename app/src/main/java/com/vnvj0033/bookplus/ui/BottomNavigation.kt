package com.vnvj0033.bookplus.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigation(navController: NavHostController) {

    var currentRoute by remember { mutableStateOf("home") }

    val onClick = { route: String ->
        navController.navigateSingleTopTo(route)
        currentRoute = route
    }

    BottomAppBar {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { onClick.invoke("home") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null)
            },
            label = { Text("홈") })

        NavigationBarItem(
            selected = currentRoute == "favorite_genre",
            onClick = { onClick.invoke("favorite_genre") },
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
        BottomNavigation(rememberNavController())
    }
}

private fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(route) {
            inclusive = true
        }
    }
