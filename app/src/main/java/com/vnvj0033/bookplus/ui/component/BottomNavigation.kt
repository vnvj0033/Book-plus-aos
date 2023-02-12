package com.vnvj0033.bookplus.ui.component

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
import com.vnvj0033.bookplus.ui.AppTheme
import com.vnvj0033.bookplus.ui.main.navigation.routeNameFavoriteGenre
import com.vnvj0033.bookplus.ui.main.navigation.routeNameHome

@Composable
fun BottomNavigation(navController: NavHostController) {

    var currentRoute by remember { mutableStateOf(routeNameHome) }

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
                    contentDescription = null)
            },
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
