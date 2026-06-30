package ua.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try{
            return bis.readLine();
        }catch(Exception e){}

        return "";
    }

    public static String askCurrencyCode() {
        writeMessage("Please enter currency code:");

        String currencyCode = readString();

        if (isCurrencyCorrect(currencyCode)) {
            return currencyCode.trim().toUpperCase();
        } else
            writeMessage("Your currency code is incorrect. Please try again.");

        return askCurrencyCode();
    }

    private static boolean isCurrencyCorrect(String currencyCode) {
        return currencyCode != null && currencyCode.trim().length() == 3;
    }
}
