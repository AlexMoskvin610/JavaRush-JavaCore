package ua.javarush.task.task39.task3913.Utils.QLQ.executorHelper;

import ua.javarush.task.task39.task3913.LogParser;

import java.util.HashSet;
import java.util.Set;

public class DataExecutorHelper {
    private final LogParser logParser;

    public DataExecutorHelper(LogParser logParser) {
        this.logParser = logParser;
    }

    public Set<Object> executeQuery(String filter2, String value) {
        switch (filter2.toLowerCase()) {
            case "ip":
                return new HashSet<>(logParser.getDatesByIP(value));
            case "user":
                return new HashSet<>();
            case "event":
                return new HashSet<>();
            case "status":
                return new HashSet<>();
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filter2);
        }
    }
}
