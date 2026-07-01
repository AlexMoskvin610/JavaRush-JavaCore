package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.Operation;
import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    public CommandExecutor() {}

    private static final Map<Operation, Command> allKnownCommandsMap;

    static  {
        allKnownCommandsMap = new HashMap<>();

        allKnownCommandsMap.put(Operation.DEPOSIT, new DepositCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, new WithdrawCommand());
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        allKnownCommandsMap.get(operation).execute();
    }
}
