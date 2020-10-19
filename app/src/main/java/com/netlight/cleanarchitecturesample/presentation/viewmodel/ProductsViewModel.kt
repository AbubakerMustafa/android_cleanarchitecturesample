package com.netlight.cleanarchitecturesample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.netlight.cleanarchitecturesample.data.remote.model.ProductResponse
import com.netlight.cleanarchitecturesample.domain.logger.Logger
import com.netlight.cleanarchitecturesample.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val logger: Logger
) : ViewModel(), CoroutineScope {


    private val _products = MutableLiveData<ProductResponse>()
    val products: LiveData<ProductResponse> = _products

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + SupervisorJob() + CoroutineExceptionHandler { _, throwable ->
            logger.e("ProductsViewModel", "Error on coroutine", throwable)
        }


    public override fun onCleared() {
        coroutineContext.cancel()
    }

    fun getProducts() {
        launch {
            val answer = getProductsUseCase.execute()
            _products.postValue(answer)
        }
    }
}