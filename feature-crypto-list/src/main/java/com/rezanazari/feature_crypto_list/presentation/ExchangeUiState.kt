package com.rezanazari.feature_crypto_list.presentation

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.rezanazari.feature_crypto_list.domain.model.Exchange
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class ExchangeUiState(
    val isLoading: Boolean = false,
    val exchangeList: List<Exchange> = emptyList(),
    val isError: Boolean = false
) : Parcelable {

    sealed class PartialState {
        object Loading : PartialState()

        data class Fetched(val list: List<Exchange>) : PartialState()

        data class Error(val throwable: Throwable) : PartialState()
    }
}
