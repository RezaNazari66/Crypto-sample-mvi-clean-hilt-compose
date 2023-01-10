package com.rezanazari.feature_crypto_list.data.repository

import com.rezanazari.feature_crypto_list.data.mapper.toDomainModel
import com.rezanazari.feature_crypto_list.data.remote.api.ExchangeApi
import com.rezanazari.feature_crypto_list.domain.model.Exchange
import com.rezanazari.feature_crypto_list.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExchangeRepositoryImpl @Inject constructor(private val apiService: ExchangeApi) :
    ExchangeRepository {

    override fun getExchangeList(): Flow<List<Exchange>> {
        return (flow {
            apiService.getExchangesPairs().data?.mapNotNull {
                it?.toDomainModel()
            }
                .also {
                    if (it == null) emit(emptyList<Exchange>()) else emit(it)
                }
        }.catch { it.printStackTrace() })

    }

}