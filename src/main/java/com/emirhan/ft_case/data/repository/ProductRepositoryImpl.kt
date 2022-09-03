package com.emirhan.ft_case.data.repository

import com.emirhan.ft_case.data.service.ProductService
import com.emirhan.ft_case.domain.entity.ProductEntity
import com.emirhan.ft_case.domain.repository.ProductRepository
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    private val productService: ProductService
) : ProductRepository {
    override fun addProduct(product: ProductEntity) {
        productService.addProduct(product)
    }

    override fun getExpiredProducts(): List<ProductEntity> {
        return productService.getExpiredProducts()
    }

    override fun getNotExpiredProducts(): List<ProductEntity> {
        return productService.getNotExpiredProducts()
    }
}