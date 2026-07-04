package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.CashMachine;
import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private final ResourceBundle validCreditCards =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");
    private final ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.login");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String creditCardNumber = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();

            if (creditCardNumber == null || (creditCardNumber = creditCardNumber.trim()).length() != 12 ||
                    pin == null || (pin = pin.trim()).length() != 4) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            } else {
                if (validCreditCards.containsKey(creditCardNumber) && validCreditCards.getString(creditCardNumber).equals(pin)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), creditCardNumber));

                    break;
                } else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), creditCardNumber));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }
            }
        }
    }
}