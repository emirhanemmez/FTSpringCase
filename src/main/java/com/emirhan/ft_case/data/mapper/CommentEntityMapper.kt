package com.emirhan.ft_case.data.mapper

import com.emirhan.ft_case.db.table.CommentTable
import com.emirhan.ft_case.domain.entity.CommentEntity
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toComment() = CommentEntity(
    comment = this[CommentTable.comment],
    commentDate = this[CommentTable.commentDate].toDate(),
    productId = this[CommentTable.productId],
    userId = this[CommentTable.userId]
)