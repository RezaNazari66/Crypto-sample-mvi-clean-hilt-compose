package com.rezanazari.feature_crypto_list.domain.usecase

import com.rezanazari.core.extensions.resultOf
import com.rezanazari.feature_crypto_list.domain.model.Exchange
import com.rezanazari.feature_crypto_list.domain.repository.ExchangeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retryWhen
import java.io.IOException

private const val RETRY_TIME_IN_MILLIS = 15_000L

fun interface GetExchangePairListUseCase : () -> Flow<Result<List<Exchange>>>

fun getExchangePairList(
    repository: ExchangeRepository
): Flow<Result<List<Exchange>>> = repository.getExchangeList().map {
    resultOf { it }
}.retryWhen { cause, _ ->
    if (cause is IOException) {
        emit(Result.failure(cause))
        delay(RETRY_TIME_IN_MILLIS)
        true
    } else {
        false
    }
}.catch { // for other than IOException but it will stop collecting Flow
    emit(Result.failure(it)) // also catch does re-throw CancellationException
}
