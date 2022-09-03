package com.emirhan.ft_case.controller

import com.emirhan.ft_case.domain.entity.UserEntity
import com.emirhan.ft_case.domain.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userRepository: UserRepository) {
    @PostMapping("/user")
    fun addUser(@RequestBody user: UserEntity): ResponseEntity<Any> {
        userRepository.addUser(user)
        return ResponseEntity(HttpStatus.OK)
    }
}