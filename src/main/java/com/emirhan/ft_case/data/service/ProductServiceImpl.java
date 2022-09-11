package com.emirhan.ft_case.data.service;

import com.emirhan.ft_case.data.repository.ProductRepository;
import com.emirhan.ft_case.domain.exception.DatabaseException;
import com.emirhan.ft_case.domain.mapper.ProductMapper;
import com.emirhan.ft_case.domain.model.Product;
import com.emirhan.ft_case.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void addProduct(Product product) {
        productRepository.save(productMapper.mapToEntity(product));
    }

    @Override
    public List<Product> getExpiredProducts() {
        return productRepository.findAllByExpirationDateIsLessThanEqual(new Date())
                .orElseThrow(() -> new DatabaseException("Hata oldu"))
                .stream()
                .map(productMapper::mapToModel)
                .toList();
    }

    @Override
    public List<Product> getNotExpiredProducts() {
        return productRepository.findAllByExpirationDateIsGreaterThan(new Date())
                .orElseThrow(() -> new DatabaseException("Hata oldu"))
                .stream()
                .map(productMapper::mapToModel)
                .toList();
    }
}
