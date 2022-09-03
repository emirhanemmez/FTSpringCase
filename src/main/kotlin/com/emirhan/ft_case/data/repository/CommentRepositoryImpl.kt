package com.emirhan.ft_case.data.repository

import com.emirhan.ft_case.data.service.CommentService
import com.emirhan.ft_case.domain.entity.CommentEntity
import com.emirhan.ft_case.domain.repository.CommentRepository
import org.springframework.stereotype.Repository
import java.util.Date

@Repository
class CommentRepositoryImpl(
    private val commentService: CommentService
): CommentRepository {
    override fun addComment(comment: CommentEntity) {
        commentService.addComment(comment)
    }

    override fun getUserComments(id: Int): List<CommentEntity> {
        return commentService.getUserComments(id)
    }

    override fun getProductComments(id: Int): List<CommentEntity> {
        return commentService.getProductComments(id)
    }

    override fun getProductCommentsBetweenDates(id: Int, startDate: Date, endDate: Date): List<CommentEntity> {
        return commentService.getProductCommentsBetweenDates(id, startDate, endDate)
    }

    override fun getUserCommentsBetweenDates(id: Int, startDate: Date, endDate: Date): List<CommentEntity> {
        return commentService.getUserCommentsBetweenDates(id, startDate, endDate)
    }
}