package ua.javarush.task.task39.task3913.DTO;

import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;

import java.util.Date;
import java.util.Objects;

public class LogEntry {
    private String ip;
    private String user;
    private Date date;
    private Event event;
    private int taskNumber;
    private Status status;

    public LogEntry(String ip, String user, Date date, Event event, int taskNumber, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.taskNumber = taskNumber;
        this.status = status;
    }

    @Override
    public String toString() {
        String eventString = taskNumber == 0 ? event.name() : event.name() + " " + taskNumber;

        return String.format("LogEntry[%s | %s | %s | %s | %s]",
                ip, user, date.toString(), eventString, status);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return taskNumber == logEntry.taskNumber && Objects.equals(ip, logEntry.ip) && Objects.equals(user, logEntry.user) && Objects.equals(date, logEntry.date) && event == logEntry.event && status == logEntry.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, user, date, event, taskNumber, status);
    }
}
