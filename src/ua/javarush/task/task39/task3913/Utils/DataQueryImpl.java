package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.DAO.LogReader;
import ua.javarush.task.task39.task3913.DTO.LogEntry;
import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;

import java.nio.file.Path;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class DataQueryImpl {
    private final LogReader logReader;

    public DataQueryImpl(Path logDir) {
        this.logReader = new LogReader(logDir);
    }

    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getUser().equalsIgnoreCase(user) && logEntry.getEvent().equals(event))
                .map(LogEntry::getDate)
                .collect(Collectors.toSet());
    }

    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getStatus().equals(Status.FAILED))
                .map(LogEntry::getDate)
                .collect(Collectors.toSet());
    }

    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getStatus().equals(Status.ERROR))
                .map(LogEntry::getDate)
                .collect(Collectors.toSet());
    }

    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getUser().equalsIgnoreCase(user)
                        && logEntry.getEvent().equals(Event.LOGIN))
                .map(LogEntry::getDate)
                .min(Date::compareTo)
                .orElse(null);

    }

    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getUser().equalsIgnoreCase(user)
                        && logEntry.getEvent().equals(Event.SOLVE_TASK)
                        && logEntry.getTaskNumber()==task)
                .map(LogEntry::getDate)
                .min(Date::compareTo)
                .orElse(null);
    }

    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getUser().equalsIgnoreCase(user)
                        && logEntry.getEvent().equals(Event.DONE_TASK)
                        && logEntry.getTaskNumber()==task)
                .map(LogEntry::getDate)
                .min(Date::compareTo)
                .orElse(null);
    }

    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getUser().equalsIgnoreCase(user)
                        && logEntry.getEvent().equals(Event.WRITE_MESSAGE))
                .map(LogEntry::getDate)
                .collect(Collectors.toSet());
    }

    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before){
        return logReader.getLogs().stream()
                .filter(logEntry -> isDateInRange(logEntry.getDate(), after, before))
                .filter(logEntry -> logEntry.getUser().equalsIgnoreCase(user)
                        && logEntry.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .map(LogEntry::getDate)
                .collect(Collectors.toSet());
    }

    public Set<Date> getAllUniqueDates() {
        return logReader.getLogs().stream()
                .map(LogEntry::getDate)
                .collect(Collectors.toSet());
    }

    public Set<Date> getDatesByIp(String ip) {
        return logReader.getLogs().stream()
                .filter(logEntry -> logEntry.getIp().equalsIgnoreCase(ip))
                .map(LogEntry::getDate)
                .collect(Collectors.toSet());
    }

    private boolean isDateInRange(Date date, Date after, Date before) {
        if (after != null && date.getTime() < after.getTime()) return false;
        if (before != null && date.getTime() > before.getTime()) return false;

        return true;
    }
}