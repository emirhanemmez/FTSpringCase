package com.emirhan.ft_case.domain.service;

import com.emirhan.ft_case.domain.model.Comment;

import java.util.Date;
import java.util.List;

public interface CommentService {
    List<Comment> getProductComments(Integer productId);

    List<Comment> getUserComments(Integer userId);

    List<Comment> getProductCommentsBetweenGivenDates(Integer productId, Date startDate, Date endDate);

    List<Comment> getUserCommentsBetweenGivenDates(Integer userId, Date startDate, Date endDate);
}
