package com.Tagger.taager.data.mapper

import com.Tagger.taager.data.core.Products
import com.Tagger.taager.data.network.Dto.ProductDto
import com.Tagger.taager.domain.Model.Product

fun ArrayList<ProductDto>.toProducts(): Products {
    return this.map {
        Product(
            name = it.name,
            price = it.price,
            createdAt = it.createdAt
        )
    } as Products
}