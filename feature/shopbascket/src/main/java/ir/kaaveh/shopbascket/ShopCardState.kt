package ir.kaaveh.shopbascket

data class ShopCardState(
    val isLoading: Boolean = false,
    val shopCard: ShopCard,
    val error: String = "",
)