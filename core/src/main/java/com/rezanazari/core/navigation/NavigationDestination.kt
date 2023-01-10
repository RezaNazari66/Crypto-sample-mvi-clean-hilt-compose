package com.rezanazari.core.navigation

sealed class NavigationDestination(
    val route: String
) {
    object Exchanges : NavigationDestination("ExchangeDestination")
}
