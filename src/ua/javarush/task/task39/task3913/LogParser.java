package ua.javarush.task.task39.task3913;

import ua.javarush.task.task39.task3913.Utils.DataQueryImpl;
import ua.javarush.task.task39.task3913.Utils.EventAndStatusQueryImpl;
import ua.javarush.task.task39.task3913.Utils.IPQueryImpl;
import ua.javarush.task.task39.task3913.Utils.QLQ.QLQueryExecutor;
import ua.javarush.task.task39.task3913.Utils.UserQueryImpl;
import ua.javarush.task.task39.task3913.query.*;

import java.nio.file.Path;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private final IPQueryImpl ipQuery;
    private final UserQueryImpl userQuery;
    private final DataQueryImpl dataQuery;
    private final EventAndStatusQueryImpl eventAndStatusQuery;
    private final QLQueryExecutor queryExecutor;

    public LogParser(Path logDir) {
        this.ipQuery = new IPQueryImpl(logDir);
        this.userQuery = new UserQueryImpl(logDir);
        this.dataQuery = new DataQueryImpl(logDir);
        this.eventAndStatusQuery = new EventAndStatusQueryImpl(logDir);
        this.queryExecutor = new QLQueryExecutor(logDir);
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

    public Set<String> getIPsByDate(Date date, Date after, Date before) {
        return ipQuery.getIPsByDate(date, after, before);
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

    public Set<String> getUsersForEvent(String event) {
        return userQuery.getUsersByEvent(event);
    }

    public Set<String> getUsersForStatus(String status) {
        return userQuery.getUsersByStatus(status);
    }

    public Set<String> getUsersByDate(String date) {
        return userQuery.getUsersByDate(date);
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
        return null;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return userQuery.getDoneTaskUsers(after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return null;
    }

    /// /////////////DataQuery/////////////////////////////////////////////////////////////////
    public Set<Date> getDatesByIP(String ip) {
        return dataQuery.getDatesByIp(ip);
    }

    public Set<Date> getDatesByUser(String user) {
        return dataQuery.getDatesByUser(user);
    }

    public Set<Date> getDatesByEvent(String event) {
        return dataQuery.getDatesByEvent(event);
    }

    public Set<Date> getDatesByStatus(String status) {
        return dataQuery.getDatesByStatus(status);
    }

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

    public Set<Date> getAllUniqueDates() {
        return dataQuery.getAllUniqueDates();
    }

    /// //////////////EventQuery////////////////////////////////////////////////////////////////////
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return eventAndStatusQuery.getNumberOfAllEvents(after, before);
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return eventAndStatusQuery.getAllEvents(after, before);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return eventAndStatusQuery.getEventsForIP(ip, after, before);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return eventAndStatusQuery.getEventsForUser(user, after, before);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return eventAndStatusQuery.getFailedEvents(after, before);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return eventAndStatusQuery.getErrorEvents(after, before);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return eventAndStatusQuery.getNumberOfAttemptToSolveTask(task, after, before);
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return eventAndStatusQuery.getNumberOfSuccessfulAttemptToSolveTask(task, after, before);
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return eventAndStatusQuery.getAllSolvedTasksAndTheirNumber(after, before);
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return eventAndStatusQuery.getAllDoneTasksAndTheirNumber(after, before);
    }


    public Set<Event> getEventForDate(String date) {
        return eventAndStatusQuery.getEventByDate(date);
    }

    public Set<Event> getEventForStatus(String status) {
        return eventAndStatusQuery.getEventByStatus(status);
    }

    /// ///////////StatusQuery///////////////////////////////////////////////////////////////
    public Set<Status> getAllUniqueStatuses() {
        return eventAndStatusQuery.getAllUniqStatuses();
    }

    public Set<Status> getStatusForIP(String ip) {
        return eventAndStatusQuery.getStatusByIP(ip);
    }

    public Set<Status> getStatusesForUser(String user) {
        return eventAndStatusQuery.getStatusByUser(user);
    }

    public Set<Status> getStatusesForDate(String date) {
        return eventAndStatusQuery.getStatusByDate(date);
    }

    public Set<Status> getStatusesForEvent(String event) {
        return eventAndStatusQuery.getStatusByEvent(event);
    }

    /// ////////////QueryExecutor///////////////////////////////////////////////////////////
    @Override
    public Set<Object> execute(String query) {
        return queryExecutor.execute(query);
    }
}
