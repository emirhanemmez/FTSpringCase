package com.emirhan.ft_case.domain.mapper;

import com.emirhan.ft_case.data.entity.UserEntity;
import com.emirhan.ft_case.domain.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @InheritInverseConfiguration
    UserEntity mapToEntity(User user);
}
