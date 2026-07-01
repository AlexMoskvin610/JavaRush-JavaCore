package ua.javarush.task.task26.task2613.command;

import ua.javarush.task.task26.task2613.exception.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException;
}
