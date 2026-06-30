package ua.javarush.task.task26.task2613;

import ua.javarush.task.task26.task2613.command.CommandExecutor;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        boolean isExit = false;

      do{
          Operation command = ConsoleHelper.askOperation();

          if(command.equals(Operation.EXIT)){
              isExit = true;
          }

          CommandExecutor.execute(command);
      }
      while (!isExit);
    }
}
