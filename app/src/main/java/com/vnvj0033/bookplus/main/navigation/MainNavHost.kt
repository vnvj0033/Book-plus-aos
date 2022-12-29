package com.vnvj0033.bookplus.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vnvj0033.bookplus.favoritegenre.FavoriteGenreCompose
import com.vnvj0033.bookplus.home.HomeCompose

private const val routeNameHome = "route_name_home"
private const val routeNameFavoriteGenre = "route_name_favorite_genre"

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = routeNameHome
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(routeNameHome) { HomeCompose() }
        composable(routeNameFavoriteGenre) { FavoriteGenreCompose() }
    }
}