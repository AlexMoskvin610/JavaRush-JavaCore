package ua.javarush.task.task39.task3913;

import ua.javarush.task.task39.task3913.Utils.DataQueryImpl;
import ua.javarush.task.task39.task3913.Utils.EventQueryImpl;
import ua.javarush.task.task39.task3913.Utils.IPQueryImpl;
import ua.javarush.task.task39.task3913.Utils.UserQueryImpl;
import ua.javarush.task.task39.task3913.query.DateQuery;
import ua.javarush.task.task39.task3913.query.EventQuery;
import ua.javarush.task.task39.task3913.query.IPQuery;
import ua.javarush.task.task39.task3913.query.UserQuery;

import java.nio.file.Path;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery {
    private final IPQueryImpl ipQuery;
    private final UserQueryImpl userQuery;
    private final DataQueryImpl dataQuery;
    private final EventQueryImpl eventQuery;

    public LogParser(Path logDir) {
        this.ipQuery = new IPQueryImpl(logDir);
        this.userQuery = new UserQueryImpl(logDir);
        this.dataQuery = new DataQueryImpl(logDir);
        this.eventQuery = new EventQueryImpl(logDir);
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

    /// /////////////DataQuery/////////////////////////////////////////////////////////////////
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return dataQuery.getDatesForUserAndEvent(user, event, after, before);
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return dataQuery.getDatesWhenSomethingFailed(after, before);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return dataQuery.getDatesWhenErrorHappened(after, before);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return dataQuery.getDateWhenUserLoggedFirstTime(user, after, before);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return dataQuery.getDateWhenUserSolvedTask(user, task, after, before);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return dataQuery.getDateWhenUserDoneTask(user, task, after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return dataQuery.getDatesWhenUserWroteMessage(user, after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return dataQuery.getDatesWhenUserDownloadedPlugin(user, after, before);
    }

    /// //////////////EventQuery////////////////////////////////////////////////////////////////////
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return eventQuery.getNumberOfAllEvents(after, before);
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return eventQuery.getAllEvents(after, before);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return eventQuery.getEventsForIP(ip, after, before);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return eventQuery.getEventsForUser(user, after, before);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return eventQuery.getFailedEvents(after, before);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return eventQuery.getErrorEvents(after, before);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return eventQuery.getNumberOfAttemptToSolveTask(task, after, before);
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return eventQuery.getNumberOfSuccessfulAttemptToSolveTask(task, after, before);
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return eventQuery.getAllSolvedTasksAndTheirNumber(after, before);
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return eventQuery.getAllDoneTasksAndTheirNumber(after, before);
    }
}