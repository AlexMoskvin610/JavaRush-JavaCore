package ua.javarush.task.task39.task3913.Utils.QLQ;

import ua.javarush.task.task39.task3913.LogParser;

import java.util.HashSet;
import java.util.Set;

public class IPExecutorHelper {
    private final LogParser logParser;

    public IPExecutorHelper(LogParser logParser) {
        this.logParser = logParser;
    }

    public Set<Object> executeQuery(String filter2, String value) {
        System.out.println("Executing query: " + filter2 + " value: " + value);
        switch (filter2.toLowerCase()) {
            case "user":
                return new HashSet<>(logParser.getIPsForUser(value, null, null));
            case "date":
                return new HashSet<>(logParser.getDatesForUserAndEvent(value, null, null, null ));
            case "event":
                return new HashSet<>();
            case "status":
                return new HashSet<>();
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filter2);
        }
    }
}
