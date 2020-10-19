package com.netlight.cleanarchitecturesample.data.repository

import com.netlight.cleanarchitecturesample.data.remote.model.ProductResponse
import com.netlight.cleanarchitecturesample.data.remote.source.ProductDataSource
import com.netlight.cleanarchitecturesample.domain.repository.ProductRepository

class ProductRepositoryImpl(private val dataSource: ProductDataSource) : ProductRepository {
    override suspend fun getProducts(): ProductResponse = dataSource.getProducts()
}
