package com.emirhan.ft_case.data.repository

import com.emirhan.ft_case.data.service.UserService
import com.emirhan.ft_case.domain.entity.UserEntity
import com.emirhan.ft_case.domain.repository.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userService: UserService
): UserRepository {
    override fun addUser(user: UserEntity) {
        userService.addUser(user)
    }
}