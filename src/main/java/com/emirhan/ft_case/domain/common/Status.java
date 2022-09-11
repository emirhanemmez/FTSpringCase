package com.emirhan.ft_case.domain.common;

public enum Status {
    Success("success"),
    Fail("fail");

    public final String name;

    Status(String name) {
        this.name = name;
    }
}
