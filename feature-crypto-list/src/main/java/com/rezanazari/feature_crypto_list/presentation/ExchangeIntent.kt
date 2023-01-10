package com.rezanazari.feature_crypto_list.presentation

sealed class ExchangeIntent {
    object GetExchanges : ExchangeIntent()
    data class ExchangeClicked(val id: String) : ExchangeIntent()
}
