package ua.javarush.task.task39.task3913.Utils.QLQ.executorHelper;

import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.LogParser;
import ua.javarush.task.task39.task3913.Status;
import ua.javarush.task.task39.task3913.Utils.common.DateFormatter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class IPExecutorHelper {
    private final LogParser logParser;

    public IPExecutorHelper(LogParser logParser) {
        this.logParser = logParser;
    }

    public Set<Object> executeQuery(String filter2, String value) {
        switch (filter2.toLowerCase()) {
            case "user":
                return new HashSet<>(logParser.getIPsForUser(value, null, null));
            case "date":
                return new HashSet<>(logParser.getIPsByDate(DateFormatter.parseDate(value), null, null));
            case "event":
                return new HashSet<>(logParser.getIPsForEvent(Event.valueOf(value.toUpperCase()), null, null));
            case "status":
                return new HashSet<>(logParser.getIPsForStatus(Status.valueOf(value.toUpperCase()), null, null));
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filter2);
        }
    }

    public Set<Object> executeQueryWithDate(String filter2, String value, String after, String before) {
        Date afterDate = DateFormatter.parseDate(after);
        Date beforeDate = DateFormatter.parseDate(before);

        switch (filter2.toLowerCase()) {
            case "user":
                return new HashSet<>(logParser.getIPsForUser(value, afterDate, beforeDate));
            case "date":
                return new HashSet<>(logParser.getIPsByDate(DateFormatter.parseDate(value), afterDate, beforeDate));
            case "event":
                return new HashSet<>(logParser.getUsersForEvent(value));
            case "status":
                return new HashSet<>(logParser.getUsersForStatus(value));
            default:
                throw new IllegalArgumentException("Invalid filter or value: " + filter2 + " - " + value);
        }
    }
}