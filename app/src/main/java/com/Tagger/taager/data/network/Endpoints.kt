package com.Tagger.taager.data.network

import com.Tagger.taager.data.network.Dto.ProductDto
import retrofit2.http.GET

interface Endpoints {

    @GET("/taager/api/interview/products")
    suspend fun getProducts(): ArrayList<ProductDto>
}