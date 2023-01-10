package com.rezanazari.feature_crypto_list.data.remote.api

import com.rezanazari.feature_crypto_list.data.remote.model.BaseResponseDto
import retrofit2.http.GET

interface ExchangeApi {

    @GET("exchange/pairs")
    suspend fun getExchangesPairs(): BaseResponseDto

}