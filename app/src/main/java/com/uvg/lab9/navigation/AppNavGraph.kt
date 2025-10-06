package com.uvg.lab9.navigation
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.lab9.wishlistapp.feature.profile.presentation.WishlistViewModel
import com.uvg.lab9.wishlistapp.feature.profile.presentation.WishlistScreen
import com.uvg.lab9.wishlistapp.feature.profile.presentation.ProfileScreen

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "root"
    ) {

        navigation(
            startDestination = Screen.Wishlist.route,
            route = "root"
        ) {
            composable(Screen.Wishlist.route) {
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

            composable(Screen.Profile.route) {
                val viewModel: WishlistViewModel = viewModel(
                    viewModelStoreOwner = navController.getBackStackEntry("root")
                )

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