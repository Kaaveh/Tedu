package ir.kaaveh.shopcard.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductDto(
    val name:String,
    val image: ImageDto,
){
    data class ImageDto(
        @SerializedName("file")
        val url: String,
    )
}
