package ua.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Робота з датами
*/
public class Solution {
    private static final SimpleDateFormat fullDateTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private static final SimpleDateFormat onlyDate = new SimpleDateFormat("dd.MM.yyyy");
    private static final SimpleDateFormat onlyTime = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) throws ParseException {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();

        if (date.contains(" ")) {
            calendar.setTime(fullDateTime.parse(date));
            printFullDateTime(calendar);
        } else if (date.contains(":")) {
            calendar.setTime(onlyTime.parse(date));
            printOnlyTime(calendar);
        } else {
            calendar.setTime(onlyDate.parse(date));
            printOnlyDate(calendar);
        }
    }

    private static void printOnlyDate(Calendar calendar) {
        System.out.println("День: " + calendar.get(Calendar.DATE));
        System.out.println("День тижня: " + (calendar.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
        System.out.println("День місяця: " + calendar.get(Calendar.DATE));
        System.out.println("День року: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Тиждень місяця: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Тиждень року: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Місяць: " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Рік: " + (calendar.get(Calendar.YEAR)));
    }

    private static void printOnlyTime(Calendar calendar) {
        System.out.println("AM чи PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
        System.out.println("Години: " + calendar.get(Calendar.HOUR));
        System.out.println("Години дня: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Хвилини: " + calendar.get(Calendar.MINUTE));
        System.out.println("Секунди: " + calendar.get(Calendar.SECOND));
    }

    private static void printFullDateTime(Calendar calendar) {
        printOnlyDate(calendar);
        printOnlyTime(calendar);
    }
}
