package com.emirhan.ft_case.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {
    private String status;
    private T data;
    private String error;
}

