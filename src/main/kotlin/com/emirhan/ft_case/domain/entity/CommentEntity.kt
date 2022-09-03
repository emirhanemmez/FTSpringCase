package com.emirhan.ft_case.domain.entity

import java.util.Date

data class CommentEntity(
    val comment: String,
    val commentDate: Date,
    val productId: Int,
    val userId: Int
)
