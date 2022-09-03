package com.emirhan.ft_case.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppProperties {
    @Value("\${spring.datasource.url}")
    lateinit var dbURL: String

    @Value("\${spring.datasource.host}")
    lateinit var dbHost: String

    @Value("\${spring.datasource.port}")
    lateinit var dbPort: String

    @Value("\${spring.datasource.db_name}")
    lateinit var dbName: String

    @Value("\${spring.datasource.username}")
    lateinit var dbUsername: String

    @Value("\${spring.datasource.password}")
    lateinit var dbPassword: String
}