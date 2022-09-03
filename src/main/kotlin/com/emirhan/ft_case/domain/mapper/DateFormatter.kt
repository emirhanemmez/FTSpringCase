package com.emirhan.ft_case.domain.mapper

import java.text.SimpleDateFormat
import java.util.Date

object DateFormatter {
    private val format = SimpleDateFormat("yyyy-MM-dd")

    fun String.toDate(): Date = format.parse(this)
}