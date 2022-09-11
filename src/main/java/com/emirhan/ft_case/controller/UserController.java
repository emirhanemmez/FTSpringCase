package com.emirhan.ft_case.controller;

import com.emirhan.ft_case.domain.common.BaseResponse;
import com.emirhan.ft_case.domain.common.Status;
import com.emirhan.ft_case.domain.model.User;
import com.emirhan.ft_case.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    ResponseEntity<BaseResponse<User>> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(new BaseResponse<>(Status.Success.name, user, null), HttpStatus.OK);
    }
}
