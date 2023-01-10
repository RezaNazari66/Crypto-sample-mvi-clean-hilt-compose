package com.rezanazari.feature_crypto_list.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FinancialDto(
    @Json(name = "last24h")
    val last24h: Last24hDto?
)