package com.Tagger.taager.domain.repository

import com.Tagger.taager.data.core.Products
import com.Tagger.taager.data.repositoryImp.ProductRepositoryImp

val productRepository by lazy { ProductRepositoryImp() }

interface ProductRepo {
    suspend fun requestProducts(): Products
}