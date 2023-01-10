package com.rezanazari.feature_crypto_list.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TvSymbolDto(
    @Json(name = "international")
    val international: String?,
    @Json(name = "ramzinex")
    val ramzinex: String?
)