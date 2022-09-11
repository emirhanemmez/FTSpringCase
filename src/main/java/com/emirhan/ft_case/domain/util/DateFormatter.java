package com.emirhan.ft_case.domain.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseToDate(String date) {
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
