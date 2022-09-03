package com.emirhan.ft_case.db.table

import org.jetbrains.exposed.sql.Table

object UserTable : Table("Kullanıcı") {
    val id = integer("Id").primaryKey().uniqueIndex().autoIncrement()
    val name = varchar("Adı", 50)
    val lastname = varchar("Soyadı", 50)
    val email = varchar("email", 50)
    val phone = varchar("telefon", 15)
}
