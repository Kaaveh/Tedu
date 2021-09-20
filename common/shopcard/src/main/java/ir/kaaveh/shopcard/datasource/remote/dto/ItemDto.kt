package ir.kaaveh.shopcard.datasource.remote.dto

data class ItemDto(
    val quantity: Int,
    val price: String,
    val currency: String,
    val colorPrice: String,
    val productName: String,
    val productImageURL: String,
)
