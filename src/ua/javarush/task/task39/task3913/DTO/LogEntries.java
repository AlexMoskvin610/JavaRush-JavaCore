package ua.javarush.task.task39.task3913.DTO;

import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;

import java.util.Objects;

public class LogEntries {
    private String ip;
    private String user;
    private String date;
    private Event event;
    private int taskId;
    private Status status;

    @Override
    public String toString() {
        String eventString = taskId == 0 ? event.name() : event.name() + " " + taskId;

        return String.format("LogEntries[%s | %s | %s | %s | %s]",
                ip, user, date, eventString, status);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogEntries logEntries = (LogEntries) o;
        return taskId == logEntries.taskId && Objects.equals(ip, logEntries.ip) && Objects.equals(user, logEntries.user) && Objects.equals(date, logEntries.date) && event == logEntries.event && status == logEntries.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, user, date, event, taskId, status);
    }


}
