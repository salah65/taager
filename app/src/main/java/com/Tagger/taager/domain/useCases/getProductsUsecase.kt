package com.Tagger.taager.domain.useCases

import com.Tagger.taager.data.core.Products
import com.Tagger.taager.domain.Model.Product
import com.Tagger.taager.domain.repository.ProductRepo
import com.Tagger.taager.domain.repository.productRepository

suspend fun getProductsUseCase(productRepo: ProductRepo = productRepository): Products {
    return runCatching { productRepo.requestProducts() }.getOrNull()
        ?: emptyList<Product>() as Products
}