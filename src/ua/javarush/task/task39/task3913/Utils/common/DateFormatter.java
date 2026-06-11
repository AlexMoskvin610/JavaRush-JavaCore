package ua.javarush.task.task39.task3913.Utils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public static Date parseDate(String dateString) {
        Date date;

        try {
            date = FORMATTER.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + dateString, e);
        }

        return date;
    }
}