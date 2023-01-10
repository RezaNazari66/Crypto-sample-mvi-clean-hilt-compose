package com.rezanazari.feature_crypto_list.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Exchange(
    val id: Int,
    val icon: String,
    val changePercent: Double,
    val sellPrice: BigDecimal,
    val sellPriceFormatted: String,
    val name: ExchangeName,
    val volume: String
) : Parcelable


@Parcelize
data class ExchangeName(
    val fa: String,
    val en: String
) : Parcelable
