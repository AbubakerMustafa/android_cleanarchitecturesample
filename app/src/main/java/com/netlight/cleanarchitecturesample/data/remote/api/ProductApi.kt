package com.netlight.cleanarchitecturesample.data.remote.api

import com.netlight.cleanarchitecturesample.data.remote.model.ProductResponse
import retrofit2.http.GET

interface ProductApi {

    @GET("/products-test.json")
    suspend fun getProducts(): ProductResponse
}