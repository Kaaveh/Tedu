package ir.kaaveh.cart.entity

data class ShopCard(
    val shopName: String,
    val allPrice: String,
    val currency: String,
    val items: List<Item>
)
