package ir.kaaveh.shopcard.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class ItemDto(
    val quantity: Int,
    @SerializedName("payable_price")
    val payablePrice: PayablePriceDto,
    val product: Product,
)
