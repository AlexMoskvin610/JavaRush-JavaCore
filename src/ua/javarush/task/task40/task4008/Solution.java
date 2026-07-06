package ua.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Робота з Java 8 DateTime API
*/

public class Solution {
    private final static DateTimeFormatter fullTimeFormatter = DateTimeFormatter.ofPattern("d.M.yyyy H:mm:ss");

    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        if (date.contains(" ")) {
            printFullDateTime(date);
        } else if (date.contains(":")) {
            printOnlyTime(date);
        } else {
            printOnlyDate(date);
        }
    }

    private static void printOnlyDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d.M.yyyy"));
        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        System.out.println("День: " + localDate.getDayOfMonth());
        System.out.println("День тижня: " + localDate.getDayOfWeek().getValue());
        System.out.println("День місяця: " + localDate.getDayOfMonth());
        System.out.println("День року: " + localDate.getDayOfYear());
        System.out.println("Тиждень місяця: " + localDate.get(weekFields.weekOfMonth()));
        System.out.println("Тиждень року: " + localDate.get(weekFields.weekOfYear()));
        System.out.println("Місяць: " + localDate.getMonthValue());
        System.out.println("Рік: " + localDate.getYear());
    }

    private static void printOnlyTime(String date) {
        LocalTime localTime = LocalTime.parse(date, DateTimeFormatter.ofPattern("H:mm:ss"));

        System.out.println("AM чи PM: " + localTime.format(DateTimeFormatter.ofPattern("a")));
        System.out.println("Години: " + localTime.format(DateTimeFormatter.ofPattern("K")));
        System.out.println("Години дня: " + localTime.getHour());
        System.out.println("Хвилини: " + localTime.getMinute());
        System.out.println("Секунди: " + localTime.getSecond());
    }

    private static void printFullDateTime(String date) {
        printOnlyDate(date.split(" ")[0]);
        printOnlyTime(date.split(" ")[1]);
    }
}
