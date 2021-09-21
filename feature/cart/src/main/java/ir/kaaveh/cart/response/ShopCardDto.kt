package ir.kaaveh.cart.response

import com.google.gson.annotations.SerializedName
import ir.kaaveh.cart.entity.Item
import ir.kaaveh.cart.entity.ShopCard

data class ShopCardDto(
    val shop: ShopDto,
    @SerializedName("payable_price")
    val payablePrice: PayablePriceDto,
    val items: List<ItemDto>
)

fun ShopCardDto.toShopCard(): ShopCard {
    val items = mutableListOf<Item>()
    for (item in this.items) {
        items.add(
            Item(
                quantity = item.quantity,
                price = item.payablePrice.title,
                currencyPrice = item.payablePrice.currency,
                colorPrice = item.payablePrice.color,
                productName = item.product.name,
                productImageURL = item.product.image.url
            )
        )
    }

    return ShopCard(
        shopName = shop.title,
        allPrice = payablePrice.title,
        currency = payablePrice.currency,
        items = items
    )
}