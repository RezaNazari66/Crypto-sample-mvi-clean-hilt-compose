package com.rezanazari.feature_crypto_list.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NameDto(
    @Json(name = "en")
    val en: String?,
    @Json(name = "fa")
    val fa: String?
)