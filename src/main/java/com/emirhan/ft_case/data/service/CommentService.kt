package com.emirhan.ft_case.data.service

import com.emirhan.ft_case.data.error.exception.DatabaseException
import com.emirhan.ft_case.data.mapper.toComment
import com.emirhan.ft_case.db.table.CommentTable
import com.emirhan.ft_case.domain.entity.CommentEntity
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.springframework.stereotype.Service
import java.util.Date

@Service
class CommentService {
    fun addComment(comment: CommentEntity) = transaction {
        try {
            CommentTable.insert {
                it[CommentTable.comment] = comment.comment
                it[commentDate] = DateTime(comment.commentDate)
                it[productId] = comment.productId
                it[userId] = comment.userId
            }
        } catch (e: ExposedSQLException) {
            throw DatabaseException(e.message)
        }
    }

    fun getUserComments(id: Int): List<CommentEntity> = transaction {
        try {
            CommentTable.select {
                CommentTable.userId eq id
            }.map {
                it.toComment()
            }
        } catch (e: ExposedSQLException) {
            throw DatabaseException(e.message)
        }
    }

    fun getProductComments(id: Int): List<CommentEntity> = transaction {
        try {
            CommentTable.select {
                CommentTable.productId eq id
            }.map {
                it.toComment()
            }
        } catch (e: ExposedSQLException) {
            throw DatabaseException(e.message)
        }
    }

    fun getProductCommentsBetweenDates(id: Int, startDate: Date, endDate: Date): List<CommentEntity> = transaction {
        try {
            CommentTable.select {
                (CommentTable.productId eq id) and (CommentTable.commentDate greaterEq DateTime(startDate)) and (CommentTable.commentDate lessEq DateTime(
                    endDate
                ))
            }.map {
                it.toComment()
            }
        } catch (e: ExposedSQLException) {
            throw DatabaseException(e.message)
        }
    }

    fun getUserCommentsBetweenDates(id: Int, startDate: Date, endDate: Date): List<CommentEntity> = transaction {
        try {
            CommentTable.select {
                (CommentTable.userId eq id) and (CommentTable.commentDate greaterEq DateTime(startDate)) and (CommentTable.commentDate lessEq DateTime(
                    endDate
                ))
            }.map {
                it.toComment()
            }
        } catch (e: ExposedSQLException) {
            throw DatabaseException(e.message)
        }
    }
}