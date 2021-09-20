package ir.kaaveh.shopcard.model

data class ShopCard(
    val shopName: String,
    val allPrice: String,
    val currency: String,
    val items: Item,
)
