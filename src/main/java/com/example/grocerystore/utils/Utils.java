package com.example.grocerystore.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class Utils {
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String formatDate(Date date) {
        LocalDateTime localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return  localDate.format(format);
    }


}
