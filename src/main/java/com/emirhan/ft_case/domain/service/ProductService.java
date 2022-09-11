package com.emirhan.ft_case.domain.service;

import com.emirhan.ft_case.domain.model.Product;

import java.util.List;


public interface ProductService {
    void addProduct(Product product);

    List<Product> getExpiredProducts();

    List<Product> getNotExpiredProducts();
}
