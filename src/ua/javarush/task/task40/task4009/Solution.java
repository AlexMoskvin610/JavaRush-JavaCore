package ua.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
        System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        LocalDate birthdayDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("d.M.yyyy"));
        LocalDate localDate = birthdayDate.withYear(Year.parse(year).getValue());

        return localDate.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, Locale.ITALIAN);
    }
}
