package com.vnvj0033.bookplus.presentation.controller

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vnvj0033.bookplus.data.repository.BookRepository
import com.vnvj0033.bookplus.data.repository.FakeBookRepo
import com.vnvj0033.bookplus.presentation.presenter.HomeViewModel
import com.vnvj0033.bookplus.presentation.ui.AppTheme
import com.vnvj0033.bookplus.presentation.ui.BottomNavigation
import com.vnvj0033.bookplus.presentation.ui.FavoriteGenreCompose
import com.vnvj0033.bookplus.presentation.ui.HomeCompose
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var bookRepository: BookRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                MainUI()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MainUI() {
        val navController = rememberNavController()

        val homeViewModel: HomeViewModel by viewModels(factoryProducer = {
            viewModelFactory {
                initializer {
                    HomeViewModel(bookRepository = bookRepository)
                }
            }
        })

        Scaffold(bottomBar = { BottomNavigation(navController) }) { paddingValue ->
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeCompose(
                        modifier = Modifier.padding(paddingValue),
                        viewModel = homeViewModel)
                }
                composable("favorite_genre") {
                    FavoriteGenreCompose(modifier = Modifier.padding(paddingValue))
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
    @Composable
    private fun Preview() {
        AppTheme {
            Scaffold(bottomBar = { BottomNavigation(rememberNavController()) }) {
                HomeCompose(
                    modifier = Modifier.padding(it),
                    viewModel = HomeViewModel(FakeBookRepo())
                )
            }
        }
    }
}