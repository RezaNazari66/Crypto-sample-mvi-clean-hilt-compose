package com.rezanazari.feature_crypto_list.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExchangeDto(
    @Json(name = "amount_step")
    val amountStep: Double?,
    @Json(name = "base_currency_id")
    val baseCurrencyId: Int?,
    @Json(name = "base_currency_symbol")
    val baseCurrencySymbol: BaseCurrencySymbolDto?,
    @Json(name = "base_precision")
    val basePrecision: Int?,
    @Json(name = "buy")
    val buy: String?,
    @Json(name = "crypto_box")
    val cryptoBox: Int?,
    @Json(name = "financial")
    val financial: FinancialDto?,
    @Json(name = "icon")
    val icon: String?,
    @Json(name = "name")
    val name: NameDto?,
    @Json(name = "pair_id")
    val pairId: Int?,
    @Json(name = "price_precision")
    val pricePrecision: Int?,
    @Json(name = "price_step")
    val priceStep: Int?,
    @Json(name = "quote_currency_id")
    val quoteCurrencyId: Int?,
    @Json(name = "quote_currency_symbol")
    val quoteCurrencySymbol: QuoteCurrencySymbolDto?,
    @Json(name = "quote_precision")
    val quotePrecision: Int?,
    @Json(name = "sell")
    val sell: String?,
    @Json(name = "show_order")
    val showOrder: Int?,
    @Json(name = "tv_symbol")
    val tvSymbol: TvSymbolDto?,
    @Json(name = "url_name")
    val urlName: String?,
    @Json(name = "web_link")
    val webLink: String?
)