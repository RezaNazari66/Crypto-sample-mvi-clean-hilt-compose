package com.rezanazari.feature_crypto_list.presentation.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rezanazari.core.ui.AppColor
import com.rezanazari.feature_crypto_list.domain.model.Exchange

@Composable
fun ExchangeListContent(
    exchangeList: List<Exchange>,
    onExchangeCLicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .padding(
                horizontal = 16.dp
            )
    ) {
        itemsIndexed(
            items = exchangeList,
            key = { _, exchange -> exchange.id }
        ) { index, item ->

            ExchangeItem(
                exchange = item,
                onExchangeCLicked = { onExchangeCLicked(item.id.toString()) }
            )

            if (index < exchangeList.lastIndex)
                Divider(color = AppColor.gray200, thickness = 1.dp)
        }
    }
}

