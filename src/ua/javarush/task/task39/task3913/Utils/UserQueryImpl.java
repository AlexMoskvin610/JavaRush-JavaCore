package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.DAO.LogReader;

import java.nio.file.Path;
import java.util.Date;
import java.util.Set;

public class UserQueryImpl {
    private final LogReader logReader;

    public UserQueryImpl(Path logDir) {
        this.logReader = new LogReader(logDir);
    }

    public Set<String> getAllUsers() {
        return null;
    }

    public int getNumberOfUsers(Date after, Date before) {
        return 0;
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
}
