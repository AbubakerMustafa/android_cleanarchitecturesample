package com.netlight.cleanarchitecturesample.domain.usecase

import com.netlight.cleanarchitecturesample.data.remote.model.ProductResponse
import com.netlight.cleanarchitecturesample.domain.repository.ProductRepository

class GetProductsUseCase(private val repo: ProductRepository) {
    suspend fun execute(): ProductResponse = repo.getProducts()
}