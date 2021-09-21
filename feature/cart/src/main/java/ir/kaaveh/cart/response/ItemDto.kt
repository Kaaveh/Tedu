package ir.kaaveh.cart.response

import com.google.gson.annotations.SerializedName

data class ItemDto(
    val quantity: Int,
    @SerializedName("payable_price")
    val payablePrice: PayablePriceDto,
    val product: ProductDto
)
