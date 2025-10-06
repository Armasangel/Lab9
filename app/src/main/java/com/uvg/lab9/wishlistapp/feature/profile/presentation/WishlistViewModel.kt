package com.uvg.wishlistapp.feature.wishlist.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.uvg.wishlistapp.feature.wishlist.domain.model.*

class WishlistViewModel : ViewModel() {
    private val _uiState = MutableStateFlow()
    
    val uiState: StateFlow<WishlistUiState> =
    
    init {
        loadProducts()
    }
    
    fun loadProducts() {
        val products = listOf(
            Product(1, "Laptop Gamer", false),
        )
        
    }
    
    fun toggleWishlist(productId: Int) {

    }
}
