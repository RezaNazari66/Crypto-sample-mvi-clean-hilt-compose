package com.rezanazari.feature_crypto_list.data.mapper

import com.rezanazari.core.utils.NumberUtils
import com.rezanazari.feature_crypto_list.data.remote.model.ExchangeDto
import com.rezanazari.feature_crypto_list.data.remote.model.NameDto
import com.rezanazari.feature_crypto_list.domain.model.Exchange
import com.rezanazari.feature_crypto_list.domain.model.ExchangeName


fun ExchangeDto.toDomainModel() = Exchange(
    id = pairId ?: 0,
    icon = icon.orEmpty(),
    changePercent = financial?.last24h?.changePercent ?: -1.0,
    sellPrice = NumberUtils.convertStringToBigDecimal(sell),
    sellPriceFormatted = NumberUtils.separateThousands(NumberUtils.convertStringToBigDecimal(sell))
        ?: "-",
    name = name?.toDomainModel() ?: ExchangeName("", ""),
    volume = financial?.last24h?.quoteVolume?.let { NumberUtils.suffixedNumberFormat(it) }
        ?: "-"
)


fun NameDto.toDomainModel() = ExchangeName(
    fa = fa.orEmpty(), en = en.orEmpty()
)