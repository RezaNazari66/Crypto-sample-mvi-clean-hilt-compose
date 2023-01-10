package com.rezanazari.feature_crypto_list.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Last24hDto(
    @Json(name = "base_volume")
    val baseVolume: Double?,
    @Json(name = "change_percent")
    val changePercent: Double?,
    @Json(name = "close")
    val close: Double?,
    @Json(name = "highest")
    val highest: Double?,
    @Json(name = "lowest")
    val lowest: Double?,
    @Json(name = "open")
    val `open`: Double?,
    @Json(name = "quote_volume")
    val quoteVolume: Double?
)