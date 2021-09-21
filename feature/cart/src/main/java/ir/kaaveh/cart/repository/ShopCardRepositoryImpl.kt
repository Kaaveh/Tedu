package ir.kaaveh.cart.repository

import ir.kaaveh.cart.api.RemoteAPI
import ir.kaaveh.cart.di.scope.CartScope
import ir.kaaveh.cart.entity.ShopCard
import ir.kaaveh.cart.response.toShopCard
import javax.inject.Inject

@CartScope
class ShopCardRepositoryImpl @Inject constructor(
    private val api: RemoteAPI
) : ShopCardRepository {
    override suspend fun getShopCard(): ShopCard = api.getShopCard().toShopCard()
}