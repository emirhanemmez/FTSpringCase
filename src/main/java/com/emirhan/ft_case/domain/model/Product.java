package com.emirhan.ft_case.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private String name;
    private Double price;
    private Date expirationDate;
}
