package com.uvg.lab9.wishlistapp.feature.wishlist.domain.model

data class Product(
    val id: Int,
    val name: String,
    val isWishlisted: Boolean = false
)
