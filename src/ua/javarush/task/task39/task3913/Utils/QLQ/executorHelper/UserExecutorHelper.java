package ua.javarush.task.task39.task3913.Utils.QLQ.executorHelper;

import ua.javarush.task.task39.task3913.LogParser;
import ua.javarush.task.task39.task3913.Utils.common.DateFormatter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserExecutorHelper {
    private final LogParser logParser;

    public UserExecutorHelper(LogParser logParser) {
        this.logParser = logParser;
    }

    public Set<Object> executeQuery(String filter2, String value) {
        switch (filter2.toLowerCase()) {
            case "ip":
                return new HashSet<>(logParser.getUsersForIP(value, null, null));
            case "date":
                return new HashSet<>(logParser.getUsersByDate(value));
            case "event":
                return new HashSet<>(logParser.getUsersForEvent(value));
            case "status":
                return new HashSet<>(logParser.getUsersForStatus(value));
            default:
                throw new IllegalArgumentException("Invalid filter or value: " + filter2 + " " + value);
        }
    }

    public Set<Object> executeQueryWithDate(String filter2, String value, String after, String before) {
        Date afterDate = DateFormatter.parseDate(after);
        Date beforeDate = DateFormatter.parseDate(before);

        switch (filter2.toLowerCase()) {
            case "ip":
                return new HashSet<>(logParser.getUsersForIP(value, afterDate, beforeDate));
            case "date":
                return new HashSet<>(logParser.getUsersByDate(value));
            case "event":
                return new HashSet<>(logParser.getUsersForEvent(value));
            case "status":
                return new HashSet<>(logParser.getUsersForStatus(value));
            default:
                throw new IllegalArgumentException("Invalid filter or value: " + filter2 + " " + value);
        }
    }
}