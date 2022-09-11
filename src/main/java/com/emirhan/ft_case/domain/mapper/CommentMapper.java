package com.emirhan.ft_case.domain.mapper;

import com.emirhan.ft_case.data.entity.CommentEntity;
import com.emirhan.ft_case.domain.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "userId", source = "user.id")
    Comment map(CommentEntity commentEntity);
}
