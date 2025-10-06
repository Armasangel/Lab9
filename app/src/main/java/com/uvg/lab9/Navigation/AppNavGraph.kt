package com.uvg.lab9.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.wishlistapp.feature.wishlist.presentation.WishlistViewModel
import com.uvg.wishlistapp.feature.wishlist.presentation.WishlistScreen
import com.uvg.wishlistapp.feature.profile.presentation.ProfileScreen

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "root"
    ) {
        // TODO 1: Crear un grafo de navegación anidado con route "root"
        // Esto es CRÍTICO para compartir el ViewModel
        navigation(
            startDestination = Screen.Wishlist.route,
            route = "root"
        ) {
            composable(Screen.Wishlist.route) { backStackEntry ->
                // TODO 2: Obtener el ViewModel con alcance del grafo "root"
                // Pista: viewModel(backStackEntry.rememberParent("root"))
                val viewModel: WishlistViewModel = viewModel(
                    viewModelStoreOwner = navController.getBackStackEntry("root")
                )

                WishlistScreen(
                    viewModel = viewModel,
                    onNavigateToProfile = {
                        navController.navigate(Screen.Profile.route)
                    }
                )
            }

            composable(Screen.Profile.route) { backStackEntry ->
                // TODO 3: Obtener el MISMO ViewModel usando el grafo "root"
                val viewModel: WishlistViewModel = /* TU CÓDIGO AQUÍ */

                    ProfileScreen(
                        viewModel = viewModel,
                        onNavigateBack = {
                            navController.popBackStack()
                        }
                    )
            }
        }
    }
}
