package com.uvg.lab9.navigation

sealed class Screen(val route: String) {
    data object Wishlist : Screen("wishlist")
    data object Profile : Screen("profile")
}