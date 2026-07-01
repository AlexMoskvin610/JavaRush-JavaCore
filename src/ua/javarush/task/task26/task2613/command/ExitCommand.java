package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Are you sure you want to exit? <y,n>");

        String answer = ConsoleHelper.readString();

        if ("y".equalsIgnoreCase(answer)) {
            ConsoleHelper.writeMessage("Goodbye! Thanks for using our cashMachine!");
        }
    }
}
