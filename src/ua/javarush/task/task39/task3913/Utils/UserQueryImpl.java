package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.DAO.LogReader;

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
                .map(log -> log.getUser())
                .collect(Collectors.toSet());
    }

    public int getNumberOfUsers(Date after, Date before) {
        return logReader.getLogs().stream()
                .filter(log->isDateInRange(log.getDate(), after, before))
                .map(log->log.getUser())
                .collect(Collectors.toSet()).size();
    }

    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return 0;
    }

    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return null;
    }

    public Set<String> getLoggedUsers(Date after, Date before) {
        return null;
    }

    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return null;
    }

    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return null;
    }

    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return null;
    }

    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return null;
    }

    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return null;
    }

    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return null;
    }

    private boolean isDateInRange(Date date, Date after, Date before) {
        if (after != null && date.getTime() < after.getTime()) return false;
        if (before != null && date.getTime() > before.getTime()) return false;

        return true;
    }
}
