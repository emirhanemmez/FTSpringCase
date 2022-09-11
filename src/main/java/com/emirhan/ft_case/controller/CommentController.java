package com.emirhan.ft_case.controller;

import com.emirhan.ft_case.domain.common.BaseResponse;
import com.emirhan.ft_case.domain.common.Status;
import com.emirhan.ft_case.domain.model.Comment;
import com.emirhan.ft_case.domain.service.CommentService;
import com.emirhan.ft_case.domain.util.DateFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment")
    ResponseEntity<BaseResponse<List<Comment>>> getComments(
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) Integer productId,
            @RequestParam(value = "startDate", required = false) String startDateString,
            @RequestParam(value = "endDate", required = false) String endDateString
    ) {
        Date startDate = DateFormatter.parseToDate(startDateString);
        Date endDate = DateFormatter.parseToDate(endDateString);

        boolean isDatesNotNull = startDate != null && endDate != null;

        List<Comment> commentList = null;

        if (isDatesNotNull) {
            if (productId != null) {
                commentList = commentService.getProductCommentsBetweenGivenDates(productId, startDate, endDate);
            } else if (userId != null) {
                commentList = commentService.getUserCommentsBetweenGivenDates(userId, startDate, endDate);
            }
        } else {
            if (productId != null) {
                commentList = commentService.getProductComments(productId);
            } else if (userId != null) {
                commentList = commentService.getUserComments(userId);
            }
        }

        return new ResponseEntity<>(new BaseResponse<>(Status.Success.name, commentList, null), HttpStatus.OK);
    }
}
