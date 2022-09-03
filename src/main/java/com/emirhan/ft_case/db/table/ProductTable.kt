package com.emirhan.ft_case.db.table

import org.jetbrains.exposed.sql.Table

object ProductTable : Table("Urun") {
    val id = integer("Id").primaryKey().uniqueIndex().autoIncrement()
    val name = varchar("Adı", 50)
    val price = double("Fiyat")
    val expirationDate = date("Son Kullanma Tarihi").nullable()
}