package com.emirhan.ft_case.controller;

import com.emirhan.ft_case.domain.common.BaseResponse;
import com.emirhan.ft_case.domain.common.Status;
import com.emirhan.ft_case.domain.model.Product;
import com.emirhan.ft_case.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    ResponseEntity<BaseResponse<Product>> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(new BaseResponse<>(Status.Success.name, product, null), HttpStatus.OK);
    }

    @GetMapping("/product/expired")
    ResponseEntity<BaseResponse<List<Product>>> getExpiredProducts() {
        return new ResponseEntity<>(new BaseResponse<>(Status.Success.name, productService.getExpiredProducts(), null), HttpStatus.OK);
    }

    @GetMapping("/product/notExpired")
    ResponseEntity<BaseResponse<List<Product>>> getNotExpiredProducts() {
        return new ResponseEntity<>(new BaseResponse<>(Status.Success.name, productService.getNotExpiredProducts(), null), HttpStatus.OK);
    }
}
