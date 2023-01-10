package com.rezanazari.feature_crypto_list.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rezanazari.core.BuildConfig
import com.rezanazari.core.utils.NumberUtils
import com.rezanazari.feature_crypto_list.domain.model.Exchange

@Composable
fun ExchangeItem(
    exchange: Exchange, modifier: Modifier = Modifier,
    onExchangeCLicked: (String) -> Unit
) {
    val context = LocalContext.current
    Row(
        Modifier
            .fillMaxWidth()
            .padding(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = BuildConfig.BASE_IMAGES_URL + exchange.icon,
            contentDescription = exchange.name.en,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = modifier.width(16.dp))
        Column {
            Text(
                text = exchange.name.fa,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = modifier.height(8.dp))
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Text(
                    text = exchange.volume,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
        Spacer(modifier = modifier.weight(1.0F))
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = NumberUtils.addRialAndFormat(exchange.sellPrice, context),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 18.sp,
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = NumberUtils.generatePercentNumber(exchange.changePercent, context),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.primary,
                        RoundedCornerShape(corner = CornerSize(5.dp))
                    )
                    .defaultMinSize(minWidth = 80.dp)
                    .padding(top = 4.dp, bottom = 4.dp)
            )
        }

    }

}

