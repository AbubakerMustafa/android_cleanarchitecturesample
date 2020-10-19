package com.netlight.cleanarchitecturesample.domain.repository

import com.netlight.cleanarchitecturesample.data.remote.model.ProductResponse

interface ProductRepository {

    suspend fun getProducts(): ProductResponse

}