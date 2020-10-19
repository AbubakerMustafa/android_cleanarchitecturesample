package com.netlight.cleanarchitecturesample.data.remote.source

import com.netlight.cleanarchitecturesample.data.remote.api.ProductApi
import com.netlight.cleanarchitecturesample.data.remote.model.ProductResponse

class ProductDataSource(private val api: ProductApi) {

    suspend fun getProducts(): ProductResponse {
        return api.getProducts()
    }
}
