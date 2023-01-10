package com.rezanazari.feature_crypto_list.presentation.di

import com.rezanazari.core.navigation.NavigationFactory
import com.rezanazari.feature_crypto_list.presentation.ExchangeUiState
import com.rezanazari.feature_crypto_list.presentation.navigation.ExchangeNavigationFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton
@Module
@InstallIn(ViewModelComponent::class)
object ExchangesViewModelModule {

    @Provides
    fun provideInitialExchangeUiState(): ExchangeUiState = ExchangeUiState()
}

@Module
@InstallIn(SingletonComponent::class)
interface ExchangeSingletonModule {

    @Singleton
    @Binds
    @IntoSet
    fun bindExchangeNavigationFactory(factory: ExchangeNavigationFactory): NavigationFactory
}
