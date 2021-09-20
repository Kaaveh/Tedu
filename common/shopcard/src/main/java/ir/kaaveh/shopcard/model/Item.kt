package ir.kaaveh.shopcard.model

data class Item(
    val quantity: Int,
    val payablePrice: PayablePrice,
    val product: Product,
)
