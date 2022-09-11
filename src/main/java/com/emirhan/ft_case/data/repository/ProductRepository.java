package com.emirhan.ft_case.data.repository;

import com.emirhan.ft_case.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    Optional<List<ProductEntity>> findAllByExpirationDateIsGreaterThan(Date date);

    Optional<List<ProductEntity>> findAllByExpirationDateIsLessThanEqual(Date date);
}
