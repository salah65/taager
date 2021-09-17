package com.Tagger.taager.data.repositoryImp

import com.Tagger.taager.data.core.Products
import com.Tagger.taager.data.gateways.ServerGateway
import com.Tagger.taager.data.gateways.serverGateway
import com.Tagger.taager.data.mapper.toProducts
import com.Tagger.taager.domain.repository.ProductRepo

class ProductRepositoryImp(private val server: ServerGateway = serverGateway) : ProductRepo {
    override suspend fun requestProducts(): Products {
        return server.getProducts().toProducts()
    }
}