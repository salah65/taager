package com.Tagger.taager.domain.useCases

import com.Tagger.taager.data.core.Products
import com.Tagger.taager.domain.Model.Product
import com.Tagger.taager.domain.repository.ProductRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.UnknownHostException

class GetProductsUsecaseKtTest {

    @Test
    fun `getProductsUsecase() with no network then return emptyList`() {
        runBlocking {
            //arrange
            val productsRepo = object : ProductRepo {

                override suspend fun requestProducts(): Products? {
                    throw UnknownHostException()
                }
            }

            val expected = arrayListOf<Product>()

            val actual = getProductsUseCase(productsRepo)

            assertEquals(expected, actual)
        }
    }

    @Test
    fun `getProductsUsecase() with Network Access then return products`() {
        runBlocking {
            //arrange
            val productsRepo = object : ProductRepo {

                override suspend fun requestProducts(): Products? {
                    return arrayListOf(Product(), Product(), Product())
                }
            }

            val expected = arrayListOf(Product(), Product(), Product())

            val actual = getProductsUseCase(productsRepo)

            assertEquals(expected, actual)
        }
    }

}