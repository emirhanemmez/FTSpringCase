package com.emirhan.ft_case.domain.repository

import com.emirhan.ft_case.domain.entity.ProductEntity

interface ProductRepository {
    fun addProduct(product: ProductEntity)
    fun getExpiredProducts(): List<ProductEntity>
    fun getNotExpiredProducts(): List<ProductEntity>
}