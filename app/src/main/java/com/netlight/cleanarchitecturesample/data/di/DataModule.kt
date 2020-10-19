package com.netlight.cleanarchitecturesample.data.di

import com.netlight.cleanarchitecturesample.BuildConfig
import com.netlight.cleanarchitecturesample.data.remote.api.ProductApi
import com.netlight.cleanarchitecturesample.data.remote.source.ProductDataSource
import com.netlight.cleanarchitecturesample.data.repository.ProductRepositoryImpl
import com.netlight.cleanarchitecturesample.domain.repository.ProductRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_CHECK24)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(ProductApi::class.java) }
}

private val repositoryModule = module {

    single<ProductRepository> { ProductRepositoryImpl(get()) }
    single { ProductDataSource(get()) }
}

val dataModules = repositoryModule + networkModule