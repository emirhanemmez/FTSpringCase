package com.emirhan.ft_case.data.repository;

import com.emirhan.ft_case.data.entity.CommentEntity;
import com.emirhan.ft_case.data.entity.ProductEntity;
import com.emirhan.ft_case.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    Optional<List<CommentEntity>> findAllByProduct(ProductEntity product);

    Optional<List<CommentEntity>> findAllByUser(UserEntity user);
}
