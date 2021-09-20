package ir.kaaveh.shopcard.datasource.remote.dto

import com.google.gson.annotations.SerializedName
import ir.kaaveh.shopcard.model.Item
import ir.kaaveh.shopcard.model.ShopCard

data class ShopCardDto(
    val shop: ShopDto,
    @SerializedName("payable_price")
    val payablePrice: PayablePriceDto,
    val items: ItemDto,
)

fun ShopCardDto.toShopCard(): ShopCard {
    val items = mutableListOf<Item>()
    for (item in this.items) {
        items.add(
            Item(
                quantity = item.quantity,
                price =item.payablePrice.title,
                currencyPrice =item.payablePrice.currency,
                colorPrice =item.payablePrice.color,
                productName =item.product.title,
                productImageURL =item.product.image.url,
            )
        )
    }

    return ShopCard(
        shopName = shop.title,
        allPrice = payablePrice.title,
        currency = payablePrice.currency,
        items = items,
    )
}