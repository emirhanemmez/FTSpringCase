package com.emirhan.ft_case.data.error.exception

class DatabaseException(
    message: String?,
    throwable: Throwable? = null
) : RuntimeException(message, throwable)