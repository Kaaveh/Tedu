package ir.kaaveh.shopcard.datasource.remote

import ir.kaaveh.shopcard.datasource.remote.dto.ShopCardDto
import retrofit2.http.GET

interface RemoteAPI {
    @GET("/v1/f05c5265-40fa-45aa-aa63-cbae81c74800")
    suspend fun getShopCard(): ShopCardDto
}