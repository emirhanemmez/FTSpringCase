package com.emirhan.ft_case.domain.repository

import com.emirhan.ft_case.domain.entity.UserEntity

interface UserRepository {
    fun addUser(user: UserEntity)
}