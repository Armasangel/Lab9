package com.uvg.lab9.wishlistapp.feature.profile.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.uvg.lab9.wishlistapp.feature.wishlist.domain.model.*

class WishlistViewModel : ViewModel() {

    // Estado privado mutable
    private val _uiState = MutableStateFlow(WishlistUiState())

    // Estado público inmutable
    val uiState: StateFlow<WishlistUiState> = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        // Lista de 10 productos de ejemplo
        val products = listOf(
            Product(1, "Laptop Gamer RTX 4090", false),
            Product(2, "Smartphone Samsung Galaxy S24", false),
            Product(3, "Auriculares Sony WH-1000XM5", false),
            Product(4, "Tablet iPad Pro 12.9\"", false),
            Product(5, "Smart Watch Apple Watch Series 9", false),
            Product(6, "Teclado Mecánico RGB", false),
            Product(7, "Mouse Logitech MX Master 3S", false),
            Product(8, "Monitor 4K 32\" LG UltraFine", false),
            Product(9, "Webcam Logitech Brio 4K", false),
            Product(10, "Micrófono Blue Yeti USB", false)
        )

        // Actualizar el estado con los productos
        _uiState.value = _uiState.value.copy(
            products = products,
            wishlistCount = products.count { it.isWishlisted }
        )
    }

    fun toggleWishlist(productId: Int) {
        // Crear nueva lista con el producto actualizado
        val updatedProducts = _uiState.value.products.map { product ->
            if (product.id == productId) {
                product.copy(isWishlisted = !product.isWishlisted)
            } else {
                product
            }
        }

        // Actualizar el estado de forma inmutable
        _uiState.value = _uiState.value.copy(
            products = updatedProducts,
            wishlistCount = updatedProducts.count { it.isWishlisted }
        )
    }
}