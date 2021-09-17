package com.Tagger.taager.app.features.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Tagger.taager.data.core.Products
import com.Tagger.taager.data.network.Resource
import com.Tagger.taager.domain.useCases.getProductsUseCase
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _mutableProductsFlow = MutableStateFlow<Resource<Products>>(Resource.loading())
    val productsFlow: Flow<Resource<Products>> = _mutableProductsFlow

    init {
        requestProducts()
    }

    fun requestProducts() {
        viewModelScope.launch(IO) {
            _mutableProductsFlow.value=(Resource.loading())
            val products = getProductsUseCase()
            if (products.isNotEmpty())
                _mutableProductsFlow.value=(Resource.success(products)!!)
            else
                _mutableProductsFlow.value=(Resource.error("Error", "SomeThing went wrong"))
        }
    }
}