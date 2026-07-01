package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.CurrencyManipulator;
import ua.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Map;

class WithdrawCommand implements Command {
    private CurrencyManipulator manipulator;
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Withdraw operation:");
        String currency = ConsoleHelper.askCurrencyCode();
        manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);

        requestCorrectAmount();

    }

    private void requestCorrectAmount() throws InterruptOperationException {
        boolean isAmountCorrect = false;

        while (!isAmountCorrect) {
            ConsoleHelper.writeMessage("Enter amount to withdraw:");
            int amount = Integer.parseInt(ConsoleHelper.readString());

            if (manipulator.isAmountAvailable(amount)) {
                isAmountCorrect = true;
                printReceipt(manipulator.withdrawAmount(amount));
            } else {
                ConsoleHelper.writeMessage("Insufficient funds. Try to enter amount again.");
            }
        }
    }

    private void printReceipt(Map<Integer, Integer> integerIntegerMap){

    }
}