package com.netlight.cleanarchitecturesample.presentation.di

import com.netlight.cleanarchitecturesample.domain.logger.Logger
import com.netlight.cleanarchitecturesample.presentation.logger.LoggerImpl
import com.netlight.cleanarchitecturesample.presentation.viewmodel.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

private val module: Module = module {
    viewModel { ProductsViewModel(get(), get()) }

    single<Logger> { LoggerImpl() }
}

val presentationModule = listOf(module)
