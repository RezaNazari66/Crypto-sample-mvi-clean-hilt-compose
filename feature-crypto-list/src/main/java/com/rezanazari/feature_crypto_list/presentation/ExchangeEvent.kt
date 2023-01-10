package com.rezanazari.feature_crypto_list.presentation

sealed class ExchangeEvent {
    data class ShowToast(val message:String):ExchangeEvent()
}
