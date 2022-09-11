package com.emirhan.ft_case.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private String comment;
    private Date commentDate;
    private int productId;
    private int userId;
}
