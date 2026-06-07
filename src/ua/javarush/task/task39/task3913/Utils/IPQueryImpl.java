package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;

import java.nio.file.Path;
import java.util.Date;
import java.util.Set;

public class IPQueryImpl {
    private final LogReader logReader;

    public IPQueryImpl(Path logDir) {
        this.logReader = new LogReader(logDir);
    }

    public int getNumberOfUniqueIPs(Date after, Date before) {
        return 0;
    }

    public Set<String> getUniqueIPs(Date after, Date before) {
        return null;
    }

    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}
