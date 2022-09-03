package com.emirhan.ft_case.data.service

import com.emirhan.ft_case.data.error.exception.DatabaseException
import com.emirhan.ft_case.data.mapper.toProduct
import com.emirhan.ft_case.db.table.ProductTable
import com.emirhan.ft_case.domain.entity.ProductEntity
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.or
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.springframework.stereotype.Service

@Service
class ProductService {
    fun addProduct(product: ProductEntity) = transaction {
        try {
            ProductTable.insert {
                it[name] = product.name
                it[price] = product.price
                it[expirationDate] = DateTime(product.expirationDate)
            }
        } catch (e: ExposedSQLException) {
            throw DatabaseException(e.message)
        }
    }

    fun getExpiredProducts(): List<ProductEntity> = transaction {
        try {
            ProductTable.select {
                (ProductTable.expirationDate lessEq DateTime()) or (ProductTable.expirationDate.isNull())
            }.map {
                it.toProduct()
            }
        } catch (e: ExposedSQLException) {
            throw DatabaseException(e.message)
        }
    }

    fun getNotExpiredProducts(): List<ProductEntity> = transaction {
        try {
            ProductTable.select {
                ProductTable.expirationDate greater DateTime()
            }.map {
                it.toProduct()
            }
        } catch (e: ExposedSQLException) {
            throw DatabaseException(e.message)
        }
    }
}