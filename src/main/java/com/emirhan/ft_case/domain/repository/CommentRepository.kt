package com.emirhan.ft_case.domain.repository

import com.emirhan.ft_case.domain.entity.CommentEntity
import java.util.Date

interface CommentRepository {
    fun addComment(comment: CommentEntity)
    fun getUserComments(id: Int): List<CommentEntity>
    fun getProductComments(id: Int): List<CommentEntity>
    fun getProductCommentsBetweenDates(id: Int, startDate: Date, endDate: Date): List<CommentEntity>
    fun getUserCommentsBetweenDates(id: Int, startDate: Date, endDate: Date): List<CommentEntity>
}