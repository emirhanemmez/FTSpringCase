package com.emirhan.ft_case.db.table

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object CommentTable : Table("UrunYorum") {
    init {
        integer("Id").primaryKey().autoIncrement()
    }
    val comment = varchar("Yorum", 500)
    val commentDate = date("yorumTarihi")
    val productId =
        reference("urunId", refColumn = ProductTable.id, onUpdate = ReferenceOption.CASCADE, onDelete = ReferenceOption.CASCADE)
    val userId =
        reference("kullaniciId", refColumn = UserTable.id, onUpdate = ReferenceOption.CASCADE, onDelete = ReferenceOption.CASCADE)

}