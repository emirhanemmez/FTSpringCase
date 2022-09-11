package com.emirhan.ft_case.data.service;

import com.emirhan.ft_case.data.entity.ProductEntity;
import com.emirhan.ft_case.data.entity.UserEntity;
import com.emirhan.ft_case.data.repository.CommentRepository;
import com.emirhan.ft_case.data.repository.ProductRepository;
import com.emirhan.ft_case.data.repository.UserRepository;
import com.emirhan.ft_case.domain.exception.DatabaseException;
import com.emirhan.ft_case.domain.mapper.CommentMapper;
import com.emirhan.ft_case.domain.model.Comment;
import com.emirhan.ft_case.domain.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public List<Comment> getProductComments(Integer productId) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new DatabaseException("Hata oldu"));
        return commentRepository.findAllByProduct(productEntity)
                .orElseThrow(() -> new DatabaseException("Hata oldu"))
                .stream()
                .map(CommentMapper.INSTANCE::map)
                .toList();
    }

    @Override
    public List<Comment> getUserComments(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new DatabaseException("Hata oldu"));
        return commentRepository.findAllByUser(userEntity)
                .orElseThrow(() -> new DatabaseException("Hata oldu"))
                .stream()
                .map(CommentMapper.INSTANCE::map)
                .toList();
    }

    @Override
    public List<Comment> getProductCommentsBetweenGivenDates(Integer productId, Date startDate, Date endDate) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new DatabaseException("Hata oldu"));
        return commentRepository.findAllByProduct(productEntity)
                .orElseThrow(() -> new DatabaseException("Hata oldu"))
                .stream()
                .map(CommentMapper.INSTANCE::map)
                .filter(entity ->
                        startDate.before(entity.getCommentDate()) && endDate.after(entity.getCommentDate())
                )
                .toList();
    }

    @Override
    public List<Comment> getUserCommentsBetweenGivenDates(Integer userId, Date startDate, Date endDate) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new DatabaseException("Hata oldu"));
        return commentRepository.findAllByUser(userEntity)
                .orElseThrow(() -> new DatabaseException("Hata oldu"))
                .stream()
                .map(CommentMapper.INSTANCE::map)
                .filter(entity ->
                        startDate.before(entity.getCommentDate()) && endDate.after(entity.getCommentDate())
                )
                .toList();
    }
}
