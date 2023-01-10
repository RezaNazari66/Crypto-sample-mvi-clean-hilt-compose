package com.rezanazari.feature_crypto_list.data.di

import com.rezanazari.feature_crypto_list.data.remote.api.ExchangeApi
import com.rezanazari.feature_crypto_list.data.repository.ExchangeRepositoryImpl
import com.rezanazari.feature_crypto_list.domain.repository.ExchangeRepository
import com.rezanazari.feature_crypto_list.domain.usecase.GetExchangePairListUseCase
import com.rezanazari.feature_crypto_list.domain.usecase.getExchangePairList
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [ExchangeModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object ExchangeModule {

    @Provides
    @Singleton
    fun provideExchangeApi(
        retrofit: Retrofit
    ): ExchangeApi {
        return retrofit.create(ExchangeApi::class.java)
    }

    @Provides
    fun provideGetExchangesUseCase(
        repository: ExchangeRepository
    ): GetExchangePairListUseCase {
        return GetExchangePairListUseCase {
            getExchangePairList(repository)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindExchangeRepository(impl: ExchangeRepositoryImpl): ExchangeRepository
    }
}
