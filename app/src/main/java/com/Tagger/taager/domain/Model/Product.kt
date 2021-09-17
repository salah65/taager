package com.Tagger.taager.domain.Model

import java.io.Serializable

data class Product(
    val createdAt: String? = null,
    val name: String? = null,
    val price: Int? = null
):Serializable