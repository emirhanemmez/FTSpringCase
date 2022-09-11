package com.emirhan.ft_case.domain.model;

import lombok.Data;

@Data
public class User {
    private String name;
    private String lastname;
    private String email;
    private String phone;

    /*public UserEntity toUserEntity(){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(this, userEntity);
        return userEntity;
    }*/
}
