package com.rezanazari.feature_crypto_list.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponseDto(
    @Json(name = "data")
    val data: List<ExchangeDto?>?,
    @Json(name = "status")
    val status: Int?
)