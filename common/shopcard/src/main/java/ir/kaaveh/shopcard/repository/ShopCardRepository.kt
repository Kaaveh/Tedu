package ir.kaaveh.shopcard.repository

import ir.kaaveh.shopcard.datasource.remote.dto.ShopCardDto

interface ShopCardRepository {
    suspend fun getShopCard(): ShopCardDto
}