package ir.kaaveh.cart.response

import com.google.gson.annotations.SerializedName

data class ProductDto(
    val name: String,
    val image: ImageDto
) {
    data class ImageDto(
        @SerializedName("file")
        val url: String
    )
}
