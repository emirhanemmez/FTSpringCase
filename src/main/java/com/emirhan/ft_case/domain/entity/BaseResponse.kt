package com.emirhan.ft_case.domain.entity

data class BaseResponse<T>(
    val status: String,
    val data: T? = null,
    val error: String? = null
)

sealed class Status(val message: String) {
    object Success : Status("success")
    object Error : Status("error")
}