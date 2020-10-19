package com.netlight.cleanarchitecturesample.domain.di

import com.netlight.cleanarchitecturesample.domain.usecase.GetProductsUseCase
import org.koin.dsl.module

private val modules = module {
    single { GetProductsUseCase(get()) }
}

val domainModules = listOf(modules)