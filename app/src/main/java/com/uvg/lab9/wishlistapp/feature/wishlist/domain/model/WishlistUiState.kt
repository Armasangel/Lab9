package com.uvg.lab9.wishlistapp.feature.wishlist.domain.model

data class WishlistUiState(
    val products: List<Product> = emptyList(),
    val wishlistCount: Int = 0
)
