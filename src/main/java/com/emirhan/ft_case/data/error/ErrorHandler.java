package com.emirhan.ft_case.data.error;

import com.emirhan.ft_case.domain.common.BaseResponse;
import com.emirhan.ft_case.domain.common.Status;
import com.emirhan.ft_case.domain.exception.DatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(DatabaseException.class)
    ResponseEntity<BaseResponse<Void>> handleDatabaseException(DatabaseException exception) {
        return new ResponseEntity<>(new BaseResponse<>(Status.Fail.name, null, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
