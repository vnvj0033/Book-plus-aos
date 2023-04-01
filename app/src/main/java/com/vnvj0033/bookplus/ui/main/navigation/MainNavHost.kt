package com.vnvj0033.bookplus.ui.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vnvj0033.bookplus.feature.home.HomeCompose
import com.vnvj0033.bookplus.ui.favoritegenre.FavoriteGenreCompose
import com.vnvj0033.bookplus.ui.subscript.SubscriptCompose

const val routeNameHome = "route_name_home"
const val routeNameFavoriteGenre = "route_name_favorite_genre"
const val routeNameSubscript = "routeNameSubscript"

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
        composable(routeNameSubscript) { SubscriptCompose() }
    }
}