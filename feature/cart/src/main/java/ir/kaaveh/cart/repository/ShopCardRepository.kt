package ir.kaaveh.cart.repository

import ir.kaaveh.cart.response.ShopCardDto

interface ShopCardRepository {
    suspend fun getShopCard(): ShopCardDto
}