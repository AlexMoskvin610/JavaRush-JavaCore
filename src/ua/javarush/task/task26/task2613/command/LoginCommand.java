package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.CashMachine;
import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private final ResourceBundle validCreditCards =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Logging in...");

        while (true) {
            ConsoleHelper.writeMessage("Please specify your credit card number and pin code or type 'EXIT' for exiting.");
            String creditCardNumber = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();


            if (creditCardNumber == null || (creditCardNumber = creditCardNumber.trim()).length() != 12 ||
                    pin == null || (pin = pin.trim()).length() != 4) {
                ConsoleHelper.writeMessage("Please specify valid credit card number - 12 digits, pin code - 4 digits.");
            } else {
                if (validCreditCards.containsKey(creditCardNumber) && validCreditCards.getString(creditCardNumber).equals(pin)) {
                    ConsoleHelper.writeMessage(String.format("Verification for card %s successfully completed.", creditCardNumber));

                    break;
                } else {
                    ConsoleHelper.writeMessage(String.format("Card %s is not valid.", creditCardNumber));
                    ConsoleHelper.writeMessage("Please try again.");
                }
            }
        }
    }
}