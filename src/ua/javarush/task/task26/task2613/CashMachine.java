package ua.javarush.task.task26.task2613;

import ua.javarush.task.task26.task2613.command.CommandExecutor;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class CashMachine {
    private static final ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common");

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        try {
            Operation operation = Operation.LOGIN;
            CommandExecutor.execute(operation);
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException ignored) {
            ConsoleHelper.writeMessage(res.getString("the.end"));
        }
    }
}
