package com.Tagger.taager.data.gateways

import com.Tagger.taager.data.network.Dto.ProductDto
import com.Tagger.taager.data.network.Endpoints
import com.Tagger.taager.data.network.RetrofitInstance

val serverGateway by lazy { ServerGatewayImplementer() }

class ServerGatewayImplementer(private val api: Endpoints = RetrofitInstance.getService()) :
    ServerGateway {
    override suspend fun getProducts(): ArrayList<ProductDto> {
        return api.getProducts()
    }

}

interface ServerGateway {

    suspend fun getProducts(): ArrayList<ProductDto>
}