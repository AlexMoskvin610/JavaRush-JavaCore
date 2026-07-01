package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.CurrencyManipulator;
import ua.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

class DepositCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String [] twoDigits = ConsoleHelper.getValidTwoDigits(currencyCode);

        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        manipulator.addAmount(Integer.parseInt(twoDigits[0]), Integer.parseInt(twoDigits[1]));

        ConsoleHelper.writeMessage("Deposited " + currencyCode + " - " + getSum(twoDigits));
    }

    private int getSum(String[] twoDigits) {
        return Integer.parseInt(twoDigits[0]) * Integer.parseInt(twoDigits[1]);
    }
}
