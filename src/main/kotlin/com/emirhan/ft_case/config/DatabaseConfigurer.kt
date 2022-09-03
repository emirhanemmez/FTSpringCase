package com.emirhan.ft_case.config

import com.emirhan.ft_case.db.table.CommentTable
import com.emirhan.ft_case.db.table.ProductTable
import com.emirhan.ft_case.db.table.UserTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class DatabaseConfigurer {

    @Autowired
    private lateinit var appProperties: AppProperties

    @PostConstruct
    fun initDatabase() {
        Database.connect(
            url = appProperties.dbURL + "${appProperties.dbHost}:${appProperties.dbPort}/${appProperties.dbName}",
            driver = "org.postgresql.Driver",
            user = appProperties.dbUsername,
            password = appProperties.dbPassword
        )

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(UserTable, ProductTable, CommentTable)
        }
    }
}