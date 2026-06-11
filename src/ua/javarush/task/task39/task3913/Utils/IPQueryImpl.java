package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.DAO.LogReader;
import ua.javarush.task.task39.task3913.DTO.LogEntry;
import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;

import java.nio.file.Path;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class IPQueryImpl {
    private final LogReader logReader;

    public IPQueryImpl(Path logDir) {
        this.logReader = new LogReader(logDir);
    }

    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    public Set<String> getUniqueIPs(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(entry -> isDateInRange(entry.getDate(), after, before))
                .map(LogEntry::getIp)
                .collect(Collectors.toSet());
    }

    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(entry -> isDateInRange(entry.getDate(), after, before))
                .filter(entry -> entry.getUser().equals(user))
                .map(LogEntry::getIp)
                .collect(Collectors.toSet());
    }

    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(entry -> isDateInRange(entry.getDate(), after, before))
                .filter(entry -> entry.getEvent() == event)
                .map(LogEntry::getIp)
                .collect(Collectors.toSet());
    }

    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(entry -> isDateInRange(entry.getDate(), after, before))
                .filter(entry -> entry.getStatus() == status)
                .map(LogEntry::getIp)
                .collect(Collectors.toSet());
    }

    private boolean isDateInRange(Date date, Date after, Date before) {
        if (after != null && date.getTime() < after.getTime()) return false;
        if (before != null && date.getTime() > before.getTime()) return false;

        return true;
    }
}