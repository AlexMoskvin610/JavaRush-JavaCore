package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.CurrencyManipulator;
import ua.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;

class InfoCommand implements Command {
    @Override
    public void execute() {
        Collection<CurrencyManipulator> allManipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        if (allManipulators.isEmpty()) {
            ConsoleHelper.writeMessage("No money available.");
            return;
        }

        boolean isMoneyAvailable = false;

        for (CurrencyManipulator manipulator : allManipulators) {
            if (manipulator.hasMoney()) {
                isMoneyAvailable = true;

                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }

        if (!isMoneyAvailable) {
            ConsoleHelper.writeMessage("No money available.");
        }
    }
}
