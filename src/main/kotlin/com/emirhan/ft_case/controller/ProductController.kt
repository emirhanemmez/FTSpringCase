package com.emirhan.ft_case.controller

import com.emirhan.ft_case.domain.entity.BaseResponse
import com.emirhan.ft_case.domain.entity.ProductEntity
import com.emirhan.ft_case.domain.entity.Status
import com.emirhan.ft_case.domain.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val productRepository: ProductRepository) {
    @PostMapping("/product")
    fun addProduct(@RequestBody product: ProductEntity): ResponseEntity<BaseResponse<Any>> {
        productRepository.addProduct(product)
        return ResponseEntity(BaseResponse(Status.Success.message), HttpStatus.OK)
    }

    @GetMapping("/product/expired")
    fun getExpiredProducts(): ResponseEntity<BaseResponse<List<ProductEntity>>> {
        val productList = productRepository.getExpiredProducts()
        return ResponseEntity(BaseResponse(Status.Success.message, productList), HttpStatus.OK)
    }

    @GetMapping("/product/notExpired")
    fun getNotExpiredProducts(): ResponseEntity<BaseResponse<List<ProductEntity>>> {
        val productList = productRepository.getNotExpiredProducts()
        return ResponseEntity(BaseResponse(Status.Success.message, productList), HttpStatus.OK)
    }
}