package com.emirhan.ft_case.data.service

import com.emirhan.ft_case.data.error.exception.DatabaseException
import com.emirhan.ft_case.db.table.UserTable
import com.emirhan.ft_case.domain.entity.UserEntity
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class UserService {
    fun addUser(user: UserEntity) = transaction {
        try {
            UserTable.insert {
                it[name] = user.name
                it[lastname] = user.lastname
                it[email] = user.email
                it[phone] = user.phone
            }
        } catch (e: ExposedSQLException) {
            throw DatabaseException(e.message)
        }
    }
}