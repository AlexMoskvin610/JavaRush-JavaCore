package ua.javarush.task.task39.task3913.Utils.QLQ.executorHelper;

import ua.javarush.task.task39.task3913.LogParser;

import java.util.HashSet;
import java.util.Set;

public class StatusExecutorHelper {
    private final LogParser logParser;

    public StatusExecutorHelper(LogParser logParser) {
        this.logParser = logParser;
    }

    public Set<Object> executeQuery(String filter2, String value) {
        switch (filter2.toLowerCase()) {
            case "ip":
                return new HashSet<>(logParser.getStatusForIP(value));
            case "user":
                return new HashSet<>(logParser.getStatusesForUser(value));
            case "date":
                return new HashSet<>(logParser.getStatusesForDate(value));
            case "event":
                return new HashSet<>(logParser.getStatusesForEvent(value));
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filter2);
        }
    }
}
