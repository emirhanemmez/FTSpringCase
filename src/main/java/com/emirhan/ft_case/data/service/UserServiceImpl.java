package com.emirhan.ft_case.data.service;

import com.emirhan.ft_case.data.entity.UserEntity;
import com.emirhan.ft_case.data.repository.UserRepository;
import com.emirhan.ft_case.domain.mapper.UserMapper;
import com.emirhan.ft_case.domain.model.User;
import com.emirhan.ft_case.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserEntity addUser(final User user) {
        return userRepository.save(userMapper.mapToEntity(user));
    }
}
