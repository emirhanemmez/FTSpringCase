package com.emirhan.ft_case.data.mapper

import com.emirhan.ft_case.db.table.ProductTable
import com.emirhan.ft_case.domain.entity.ProductEntity
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toProduct() =
    ProductEntity(
        name = this[ProductTable.name],
        price = this[ProductTable.price],
        expirationDate = this[ProductTable.expirationDate]?.toDate(),
    )