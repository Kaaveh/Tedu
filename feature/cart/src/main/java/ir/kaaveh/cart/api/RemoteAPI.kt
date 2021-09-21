package ir.kaaveh.cart.api

import ir.kaaveh.cart.response.ShopCardDto
import retrofit2.http.GET

interface RemoteAPI {
    @GET("/v1/f05c5265-40fa-45aa-aa63-cbae81c74800")
    suspend fun getShopCard(): ShopCardDto
}