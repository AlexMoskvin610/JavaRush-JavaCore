package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.DAO.LogReader;
import ua.javarush.task.task39.task3913.DTO.LogEntry;
import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;
import ua.javarush.task.task39.task3913.Utils.common.DateFormatter;

import java.nio.file.Path;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EventAndStatusQueryImpl {
    private final LogReader logReader;

    public EventAndStatusQueryImpl(Path logDir) {
        this.logReader = new LogReader(logDir);
    }

    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    public Set<Event> getAllEvents(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .map(LogEntry::getEvent)
                .collect(Collectors.toSet());
    }

    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getIp().equalsIgnoreCase(ip))
                .map(LogEntry::getEvent)
                .collect(Collectors.toSet());
    }

    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getUser().equalsIgnoreCase(user))
                .map(LogEntry::getEvent)
                .collect(Collectors.toSet());
    }

    public Set<Event> getFailedEvents(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getStatus().equals(Status.FAILED))
                .map(LogEntry::getEvent)
                .collect(Collectors.toSet());
    }

    public Set<Event> getErrorEvents(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getStatus().equals(Status.ERROR))
                .map(LogEntry::getEvent)
                .collect(Collectors.toSet());
    }

    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getEvent().equals(Event.SOLVE_TASK)
                        && logEntry.getTaskNumber() == task)
                .collect(Collectors.toSet()).size();
    }

    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getEvent().equals(Event.DONE_TASK)
                        && logEntry.getTaskNumber() == task)
                .collect(Collectors.toSet()).size();
    }

    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(log -> log.getEvent().equals(Event.SOLVE_TASK))
                .collect(Collectors.groupingBy(
                        LogEntry::getTaskNumber,
                        Collectors.summingInt(log -> 1)));
    }

    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(log -> log.getEvent().equals(Event.DONE_TASK))
                .collect(Collectors.groupingBy(
                        LogEntry::getTaskNumber,
                        Collectors.summingInt(log -> 1)));
    }

    public Set<Status> getAllUniqStatuses() {
        return logReader.getLogs().stream()
                .map(LogEntry::getStatus)
                .collect(Collectors.toSet());
    }

    public Set<Event> getEventByDate(String date) {
        return logReader.getLogs().stream()
                .filter(logEntry -> logEntry.getDate().equals(DateFormatter.parseDate(date)))
                .map(LogEntry::getEvent)
                .collect(Collectors.toSet());
    }

    public Set<Event> getEventByStatus(String status) {
        return logReader.getLogs().stream()
                .filter(logEntry -> logEntry.getStatus().name().equalsIgnoreCase(status))
                .map(LogEntry::getEvent)
                .collect(Collectors.toSet());
    }

    public Set<Status> getStatusByIP(String ip) {
        return logReader.getLogs().stream()
                .filter(logEntry -> logEntry.getIp().equalsIgnoreCase(ip))
                .map(LogEntry::getStatus)
                .collect(Collectors.toSet());
    }

    public Set<Status> getStatusByUser(String user) {
        return logReader.getLogs().stream()
                .filter(logEntry -> logEntry.getUser().equalsIgnoreCase(user))
                .map(LogEntry::getStatus)
                .collect(Collectors.toSet());
    }

    public Set<Status> getStatusByDate(String date) {
        return logReader.getLogs().stream()
                .filter(logEntry -> logEntry.getDate().equals(DateFormatter.parseDate(date)))
                .map(LogEntry::getStatus)
                .collect(Collectors.toSet());
    }

    public Set<Status> getStatusByEvent(String event) {
        return logReader.getLogs().stream()
                .filter(logEntry -> logEntry.getEvent().name().equalsIgnoreCase(event))
                .map(LogEntry::getStatus)
                .collect(Collectors.toSet());
    }

    private boolean isDateInRange(Date date, Date after, Date before) {
        if (after != null && !date.after(after)) return false;
        if (before != null && !date.before(before)) return false;

        return true;
    }
}
