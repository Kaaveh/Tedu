package ir.kaaveh.cart.repository

import ir.kaaveh.cart.api.RemoteAPI
import ir.kaaveh.cart.response.ShopCardDto
import javax.inject.Inject

class ShopCardRepositoryImpl @Inject constructor(
    private val api: RemoteAPI
): ShopCardRepository {
    override suspend fun getShopCard(): ShopCardDto = api.getShopCard()
}