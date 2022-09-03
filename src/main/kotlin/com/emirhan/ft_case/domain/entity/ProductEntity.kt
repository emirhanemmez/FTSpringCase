package com.emirhan.ft_case.domain.entity

import java.util.Date

data class ProductEntity(
    val name: String,
    val price: Double,
    val expirationDate: Date?
)
