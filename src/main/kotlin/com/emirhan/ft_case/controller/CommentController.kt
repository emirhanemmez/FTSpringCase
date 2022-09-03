package com.emirhan.ft_case.controller

import com.emirhan.ft_case.domain.entity.BaseResponse
import com.emirhan.ft_case.domain.entity.CommentEntity
import com.emirhan.ft_case.domain.entity.Status
import com.emirhan.ft_case.domain.mapper.DateFormatter.toDate
import com.emirhan.ft_case.domain.repository.CommentRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController(private val commentRepository: CommentRepository) {
    @PostMapping("/comment")
    fun addComment(@RequestBody comment: CommentEntity): ResponseEntity<BaseResponse<Any>> {
        commentRepository.addComment(comment)
        return ResponseEntity(BaseResponse(Status.Success.message), HttpStatus.OK)
    }

    @GetMapping("/comment")
    fun getComments(
        @RequestParam userId: Int?,
        @RequestParam productId: Int?,
        @RequestParam startDate: String?,
        @RequestParam endDate: String?
    ): ResponseEntity<BaseResponse<List<CommentEntity>>> {
        var commentList = listOf<CommentEntity>()
        if (userId != null) {
            commentList = if (startDate != null && endDate != null) {
                commentRepository.getUserCommentsBetweenDates(userId, startDate.toDate(), endDate.toDate())
            } else {
                commentRepository.getUserComments(userId)
            }
        } else {
            if (productId != null) {
                commentList = if (startDate != null && endDate != null) {
                    commentRepository.getProductCommentsBetweenDates(productId, startDate.toDate(), endDate.toDate())
                } else {
                    commentRepository.getProductComments(productId)
                }
            }
        }

        return ResponseEntity(BaseResponse(Status.Success.message, commentList), HttpStatus.OK)
    }

}