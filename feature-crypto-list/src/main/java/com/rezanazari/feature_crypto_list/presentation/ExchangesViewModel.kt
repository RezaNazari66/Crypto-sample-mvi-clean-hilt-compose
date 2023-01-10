package com.rezanazari.feature_crypto_list.presentation

import androidx.lifecycle.SavedStateHandle
import com.rezanazari.core.base.BaseViewModel
import com.rezanazari.feature_crypto_list.domain.usecase.GetExchangePairListUseCase
import com.rezanazari.feature_crypto_list.presentation.ExchangeIntent.ExchangeClicked
import com.rezanazari.feature_crypto_list.presentation.ExchangeIntent.GetExchanges
import com.rezanazari.feature_crypto_list.presentation.ExchangeUiState.PartialState
import com.rezanazari.feature_crypto_list.presentation.ExchangeUiState.PartialState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class ExchangesViewModel @Inject constructor(
    private val getExchangeUseCase: GetExchangePairListUseCase,
    savedStateHandle: SavedStateHandle,
    exchangeInitialState: ExchangeUiState
) : BaseViewModel<ExchangeUiState, PartialState, ExchangeEvent, ExchangeIntent>(
        savedStateHandle,
        exchangeInitialState
    ) {

    init {
        acceptIntent(GetExchanges)
    }
    override fun mapIntents(intent: ExchangeIntent): Flow<PartialState> = when (intent) {
        is GetExchanges -> getExchanges()
        is ExchangeClicked -> exchangeClicked(intent.id)
    }

    private fun exchangeClicked(id: String): Flow<PartialState> {
        publishEvent(ExchangeEvent.ShowToast("$id clicked"))
        return emptyFlow()
    }

    private fun getExchanges(): Flow<PartialState> = flow {
        getExchangeUseCase()
            .onStart {
                emit(Loading)
            }
            .collect { result ->
                result
                    .onSuccess { exchangeList ->
                        emit(Fetched(exchangeList))
                    }
                    .onFailure {
                        emit(Error(it))
                    }
            }
    }

    override fun reduceUiState(
        previousState: ExchangeUiState,
        partialState: PartialState
    ): ExchangeUiState = when (partialState) {
        is Loading -> previousState.copy(
            isLoading = true,
            isError = false
        )
        is Fetched -> previousState.copy(
            isLoading = false,
            exchangeList = partialState.list,
            isError = false
        )
        is Error -> previousState.copy(
            isLoading = false,
            isError = true
        )
    }
}