package com.example.codingtestsample.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.codingtestsample.presentation.ui.ItemDetailsScreen
import com.example.codingtestsample.presentation.ui.ItemListScreen
import com.example.codingtestsample.presentation.ui.SplashScreen
import com.example.codingtestsample.presentation.viewmodel.ItemListViewModel
import com.example.codingtestsample.presentation.viewmodel.SplashViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") { backStackEntry ->
            val viewModel = hiltViewModel<SplashViewModel>(backStackEntry)
            SplashScreen(viewModel = viewModel) {
                navController.navigate("item_list") {
                    popUpTo("splash") { inclusive = true } // Clear splash from back stack
                }
            }
        }
        composable("item_list") { backStackEntry ->
            val viewModel: ItemListViewModel = hiltViewModel(backStackEntry)
            ItemListScreen(viewModel = viewModel, navController = navController)
        }
        composable("itemDetails/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId") ?: ""
            ItemDetailsScreen(itemId = itemId, navController = navController)  // Pass itemId to ItemDetailsScreen
        }
    }
}

