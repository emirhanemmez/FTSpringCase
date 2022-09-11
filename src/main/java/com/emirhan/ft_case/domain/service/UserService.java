package com.emirhan.ft_case.domain.service;


import com.emirhan.ft_case.data.entity.UserEntity;
import com.emirhan.ft_case.domain.model.User;

public interface UserService {
    UserEntity addUser(User user);
}
