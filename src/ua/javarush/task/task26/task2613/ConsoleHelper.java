package ua.javarush.task.task26.task2613;

import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static final ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try{
            String input = bis.readLine();
            chekIsExit(input);

            return input;
        } catch (IOException ignored) {}

        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));

        String currencyCode = readString();

        if (isCurrencyCorrect(currencyCode)) {
            return currencyCode.trim().toUpperCase();
        } else
            writeMessage(res.getString("invalid.data"));

        return askCurrencyCode();
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeMessage(res.getString("operation.INFO"));
        writeMessage(res.getString("operation.DEPOSIT"));
        writeMessage(res.getString("operation.WITHDRAW"));
        writeMessage(res.getString("operation.EXIT"));

        try {
            String answer = ConsoleHelper.readString();

            chekIsExit(answer);

            int choice = Integer.parseInt(answer);
            
            return Operation.getAllowableOperationByOrdinal(choice);
        } catch (IllegalArgumentException e) {
            writeMessage(res.getString("invalid.data"));
        }

        return askOperation();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        try {
            String input = readString().toLowerCase();

            chekIsExit(input);

            if (input.matches("\\d+ \\d+")) {

                return input.trim().split(" ");
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            writeMessage(res.getString("invalid.data"));
        }

        return getValidTwoDigits(currencyCode);
    }

    private static boolean isCurrencyCorrect(String currencyCode) {
        return currencyCode != null && currencyCode.trim().length() == 3;
    }

    private static void chekIsExit(String input) throws InterruptOperationException {
        if ("exit".equalsIgnoreCase(input)) {
            throw new InterruptOperationException();
        }
    }
}
