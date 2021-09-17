package com.Tagger.taager.app.features.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Tagger.taager.data.core.Products
import com.Tagger.taager.data.network.Resource
import com.Tagger.taager.domain.useCases.getProductsUseCase
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _mutableProductsFlow = MutableStateFlow<Resource<Products>>(Resource.loading())
    val productsFlow = _mutableProductsFlow.asStateFlow()

    init {
        requestProducts()
    }

    private fun requestProducts() {
        viewModelScope.launch(IO) {
            val products=getProductsUseCase()
            if (products.isNotEmpty())
                _mutableProductsFlow.emit(Resource.success(products)!! )
            else
                _mutableProductsFlow.emit(Resource.error("Error","SomeThing went wrong"))
        }
    }
}