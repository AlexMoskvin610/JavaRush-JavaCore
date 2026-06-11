package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.DAO.LogReader;
import ua.javarush.task.task39.task3913.DTO.LogEntry;
import ua.javarush.task.task39.task3913.Event;

import java.nio.file.Path;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class UserQueryImpl {
    private final LogReader logReader;

    public UserQueryImpl(Path logDir) {
        this.logReader = new LogReader(logDir);
    }

    public Set<String> getAllUsers() {
        return logReader.getLogs().stream()
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }

    public int getNumberOfUsers(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(log->isDateInRange(log.getDate(), after, before))
                .map(LogEntry::getUser)
                .collect(Collectors.toSet()).size();
    }

    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(log -> log.getUser().equalsIgnoreCase(user))
                .map(LogEntry::getEvent)
                .collect(Collectors.toSet()).size();
    }

    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getIp().equalsIgnoreCase(ip))
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }

    public Set<String> getLoggedUsers(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getEvent().equals(Event.LOGIN))
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }

    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }

    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getEvent().equals(Event.WRITE_MESSAGE))
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }

    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getEvent().equals(Event.SOLVE_TASK))
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }

    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getEvent().equals(Event.SOLVE_TASK) && logEntry.getTaskNumber()==task)
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }

    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getEvent().equals(Event.DONE_TASK))
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }

    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getEvent().equals(Event.DONE_TASK) && logEntry.getTaskNumber()==task)
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }

    public Set<String> getUsersByEvent(String value) {
        return logReader.getLogs().stream()
                .filter(logEntry -> logEntry.getEvent().name().equalsIgnoreCase(value))
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());
    }
    private boolean isDateInRange(Date date, Date after, Date before) {
        if (after != null && date.getTime() < after.getTime()) return false;
        if (before != null && date.getTime() > before.getTime()) return false;

        return true;
    }
}
