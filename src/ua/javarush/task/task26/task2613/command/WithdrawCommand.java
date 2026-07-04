package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.CashMachine;
import ua.javarush.task.task26.task2613.ConsoleHelper;
import ua.javarush.task.task26.task2613.CurrencyManipulator;
import ua.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;
import ua.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private final ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.withdraw");

    private CurrencyManipulator manipulator;

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currency = ConsoleHelper.askCurrencyCode();
        manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);

        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String s = ConsoleHelper.readString();
            int amount;

            try {
                amount = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));

                continue;
            }

            if (amount <= 0) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));

                continue;
            }

            if (!manipulator.isAmountAvailable(amount)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));

                continue;
            }

            try {
                printReceipt(manipulator.withdrawAmount(amount));

                break;
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
    }

    private void printReceipt(Map<Integer, Integer> withdrewMoney){
        for (Map.Entry<Integer, Integer> entry : withdrewMoney.entrySet()) {
            ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
        }
    }
}