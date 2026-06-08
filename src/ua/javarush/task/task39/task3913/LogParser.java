package ua.javarush.task.task39.task3913;

import ua.javarush.task.task39.task3913.Utils.IPQueryImpl;
import ua.javarush.task.task39.task3913.Utils.UserQueryImpl;
import ua.javarush.task.task39.task3913.query.IPQuery;
import ua.javarush.task.task39.task3913.query.UserQuery;

import java.nio.file.Path;
import java.util.Date;
import java.util.Set;

public class LogParser implements IPQuery, UserQuery {
    private final IPQueryImpl ipQuery;
    private final UserQueryImpl userQuery;

    public LogParser(Path logDir) {
        this.ipQuery = new IPQueryImpl(logDir);
        this.userQuery = new UserQueryImpl(logDir);
    }

    /// ////////////////////////IPQuery////////////////////////////////////////////////////////////////
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return ipQuery.getNumberOfUniqueIPs(after, before);
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return ipQuery.getUniqueIPs(after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return ipQuery.getIPsForUser(user, after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return ipQuery.getIPsForEvent(event, after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return ipQuery.getIPsForStatus(status, after, before);
    }

    /// ////////////////////////////////UserQuery/////////////////////////////////////////////////////////////
    @Override
    public Set<String> getAllUsers() {
        return userQuery.getAllUsers();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return userQuery.getNumberOfUserEvents(user, after, before);
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return userQuery.getNumberOfUsers(after, before);
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return userQuery.getUsersForIP(ip, after, before);
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return userQuery.getLoggedUsers(after, before);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return userQuery.getDownloadedPluginUsers(after, before);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return userQuery.getWroteMessageUsers(after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return userQuery.getSolvedTaskUsers(after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return userQuery.getSolvedTaskUsers(after, before, task);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return userQuery.getDoneTaskUsers(after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return userQuery.getDoneTaskUsers(after, before, task);
    }
}