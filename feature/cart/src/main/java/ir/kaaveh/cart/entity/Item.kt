package ir.kaaveh.cart.entity

data class Item(
    val quantity: Int,
    val price: String,
    val currencyPrice: String,
    val colorPrice: String,
    val productName: String,
    val productImageURL: String
)
