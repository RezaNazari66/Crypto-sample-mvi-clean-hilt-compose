package com.rezanazari.feature_crypto_list.domain.repository

import com.rezanazari.feature_crypto_list.domain.model.Exchange
import kotlinx.coroutines.flow.Flow

interface ExchangeRepository {

    fun getExchangeList(): Flow<List<Exchange>>

}