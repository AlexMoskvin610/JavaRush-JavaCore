package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.CurrencyManipulator;
import ua.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;
import ua.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;

class WithdrawCommand implements Command {
    private CurrencyManipulator manipulator;

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Withdraw operation:");
        String currency = ConsoleHelper.askCurrencyCode();
        manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);

        while (true) {
            ConsoleHelper.writeMessage("Enter amount to withdraw:");
            String s = ConsoleHelper.readString();
            int amount;

            try {
                amount = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Please specify valid data.");
                continue;
            }

            if (amount <= 0) {
                ConsoleHelper.writeMessage("Please specify valid data.");
                continue;
            }

            if (!manipulator.isAmountAvailable(amount)) {
                ConsoleHelper.writeMessage("Not enough money on your account.");
                continue;
            }

            try {
                printReceipt(manipulator.withdrawAmount(amount));
                break;
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("Exact amount is not available.");

            }
        }
    }

    private void printReceipt(Map<Integer, Integer> withdrewMoney){
        for (Map.Entry<Integer, Integer> entry : withdrewMoney.entrySet()) {
            ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
        }
    }
}