package ua.javarush.task.task39.task3913.Utils.QLQ;

import ua.javarush.task.task39.task3913.LogParser;
import ua.javarush.task.task39.task3913.Utils.common.DateFormatter;

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
                return new HashSet<>(logParser.getIPsByDate(DateFormatter.parseDate(value)));
            case "event":
                return new HashSet<>();
            case "status":
                return new HashSet<>();
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filter2);
        }
    }
}
