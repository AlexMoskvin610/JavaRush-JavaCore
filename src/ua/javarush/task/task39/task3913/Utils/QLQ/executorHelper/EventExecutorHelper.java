package ua.javarush.task.task39.task3913.Utils.QLQ.executorHelper;

import ua.javarush.task.task39.task3913.LogParser;

import java.util.HashSet;
import java.util.Set;

public class EventExecutorHelper {
    private final LogParser logParser;

    public EventExecutorHelper(LogParser logParser) {
        this.logParser = logParser;
    }

    public Set<Object> executeQuery(String filter2, String value) {
        System.out.println(filter2);
        switch (filter2.toLowerCase()) {
            case "ip":
                return new HashSet<>(logParser.getEventsForIP(value, null, null));
            case "user":
                return new HashSet<>(logParser.getEventsForUser(value, null, null));
            case "date":
                return new HashSet<>(logParser.getEventForDate(value));
            case "status":
                return new HashSet<>(logParser.getEventForStatus(value));
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filter2);
        }
    }
}
