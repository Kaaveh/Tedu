package ir.kaaveh.cart.repository

import ir.kaaveh.cart.entity.ShopCard

interface ShopCardRepository {
    suspend fun getShopCard(): ShopCard
}