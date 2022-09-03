package com.emirhan.ft_case.data.error

import com.emirhan.ft_case.data.error.exception.DatabaseException
import com.emirhan.ft_case.domain.entity.BaseResponse
import com.emirhan.ft_case.domain.entity.Status
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(DatabaseException::class)
    fun handleDatabaseException(exception: DatabaseException): ResponseEntity<Any> {
        return ResponseEntity(BaseResponse<Any>(Status.Error.message, error = exception.message), HttpStatus.BAD_REQUEST)
    }
}