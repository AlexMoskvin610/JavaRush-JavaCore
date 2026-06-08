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
        return null;
    }

    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return null;
    }

    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return null;
    }

    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return null;
    }

    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return null;
    }

    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before){
        return null;
    }

    private boolean isDateInRange(Date date, Date after, Date before) {
        if (after != null && date.getTime() < after.getTime()) return false;
        if (before != null && date.getTime() > before.getTime()) return false;

        return true;
    }
}