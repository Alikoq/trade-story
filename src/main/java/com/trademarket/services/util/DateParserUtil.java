package com.trademarket.services.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParserUtil {

    public static LocalDate parseStr(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
}
