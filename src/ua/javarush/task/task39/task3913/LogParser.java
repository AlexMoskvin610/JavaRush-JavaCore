package ua.javarush.task.task39.task3913;

import ua.javarush.task.task39.task3913.Utils.IPQueryImpl;
import ua.javarush.task.task39.task3913.query.IPQuery;

import java.nio.file.Path;
import java.util.Date;
import java.util.Set;

public class LogParser implements IPQuery {
    private final IPQueryImpl ipQuery;

    public LogParser(Path logDir) {
        this.ipQuery = new IPQueryImpl(logDir);
    }

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
}