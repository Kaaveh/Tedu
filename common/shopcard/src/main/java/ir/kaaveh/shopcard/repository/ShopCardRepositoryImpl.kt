package ir.kaaveh.shopcard.repository

import ir.kaaveh.shopcard.datasource.remote.RemoteAPI
import ir.kaaveh.shopcard.datasource.remote.dto.ShopCardDto
import javax.inject.Inject

class ShopCardRepositoryImpl @Inject constructor(
    private val api: RemoteAPI,
): ShopCardRepository {
    override suspend fun getShopCard(): ShopCardDto = api.getShopCard()
}