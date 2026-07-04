package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

public class LoginCommand implements Command {
    private static final long CARD_NUMBER = 123456789012L;
    private static final long CARD_PIN = 1234L;

    @Override
    public void execute() throws InterruptOperationException {
        long[] credentials = askCredentials();

    }

    private long[] askCredentials() throws InterruptOperationException {
        long[] credentials = new long[2];

        ConsoleHelper.writeMessage("Please enter your card number:");
        String cardNumberInput = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Please enter your PIN:");
        String pinInput = ConsoleHelper.readString();

        try {
            checkInput(cardNumberInput, pinInput);

            credentials[0] = Long.parseLong(cardNumberInput);
            credentials[1] = Long.parseLong(pinInput);
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage("Invalid input. Please correct numeric values.");

            return askCredentials();
        } catch (IllegalArgumentException e) {

            return askCredentials();
        }

        if (credentials[0] == CARD_NUMBER && credentials[1] == CARD_PIN) {
            ConsoleHelper.writeMessage("Login successful.");

            return credentials;
        } else {
            ConsoleHelper.writeMessage("Invalid card number or PIN. Please try again.");

            return askCredentials();
        }
    }

    private void checkInput(String cardNumberInput, String pinInput) throws IllegalArgumentException {
        if (cardNumberInput == null || cardNumberInput.trim().isEmpty()
                || cardNumberInput.length() != 12 || !cardNumberInput.matches("\\d+")) {
            ConsoleHelper.writeMessage("Invalid card number. Please try again.");

            throw new IllegalArgumentException();
        }

        if (pinInput == null || pinInput.trim().isEmpty() || pinInput.length() != 4 || !pinInput.matches("\\d+")) {
            ConsoleHelper.writeMessage("Invalid PIN. Please try again.");

            throw new IllegalArgumentException();
        }
    }
}
