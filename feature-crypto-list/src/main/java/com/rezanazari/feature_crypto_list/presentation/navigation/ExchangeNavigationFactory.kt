package com.rezanazari.feature_crypto_list.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rezanazari.core.navigation.NavigationDestination
import com.rezanazari.core.navigation.NavigationFactory
import com.rezanazari.feature_crypto_list.presentation.composable.ExchangesRout
import javax.inject.Inject

class ExchangeNavigationFactory @Inject constructor() : NavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(NavigationDestination.Exchanges.route) {
            ExchangesRout()
        }
    }
}
