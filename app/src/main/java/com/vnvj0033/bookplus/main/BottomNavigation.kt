package com.vnvj0033.bookplus.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vnvj0033.bookplus.ui.AppTheme

@Composable
fun BottomNavigation(navController: NavHostController) {

    val backstackEntry by navController.currentBackStackEntryAsState()
    var currentRoute by remember { mutableStateOf(routeNameHome) }

    currentRoute = backstackEntry?.destination?.route ?: routeNameHome

    val onClick = { route: String ->
        navController.navigateSingleTopTo(route)
        currentRoute = route
    }

    BottomAppBar {
        NavigationBarItem(
            selected = currentRoute == routeNameHome,
            onClick = { onClick.invoke(routeNameHome) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null) },
            label = { Text("홈") })

        NavigationBarItem(
            selected = currentRoute == routeNameFavoriteGenre,
            onClick = { onClick.invoke(routeNameFavoriteGenre) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null) },
            label = { Text("선호 장르") })


        NavigationBarItem(
            selected = currentRoute == routeNameSubscript,
            onClick = { onClick.invoke(routeNameSubscript) },
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
