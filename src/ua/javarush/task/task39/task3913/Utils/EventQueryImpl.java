package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.DAO.LogReader;
import ua.javarush.task.task39.task3913.DTO.LogEntry;
import ua.javarush.task.task39.task3913.Event;

import java.nio.file.Path;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EventQueryImpl {
    private final LogReader logReader;

    public EventQueryImpl(Path logDir) {
        this.logReader = new LogReader(logDir);
    }

    public int getNumberOfAllEvents(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .map(LogEntry::getEvent)
                .collect(Collectors.toSet()).size();
    }

    public Set<Event> getAllEvents(Date after, Date before) {
        return null;
    }

    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return null;
    }

    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return null;
    }

    public Set<Event> getFailedEvents(Date after, Date before) {
        return null;
    }

    public Set<Event> getErrorEvents(Date after, Date before) {
        return null;
    }

    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return 0;
    }

    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return 0;
    }

    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return null;
    }

    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return null;
    }

    private boolean isDateInRange(Date date, Date after, Date before) {
        if (after != null && date.getTime() < after.getTime()) return false;
        if (before != null && date.getTime() > before.getTime()) return false;

        return true;
    }
}
