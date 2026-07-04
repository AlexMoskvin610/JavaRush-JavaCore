package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.CashMachine;
import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command {
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

        String answer = ConsoleHelper.readString();

        if ("y".equalsIgnoreCase(answer)) {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}
