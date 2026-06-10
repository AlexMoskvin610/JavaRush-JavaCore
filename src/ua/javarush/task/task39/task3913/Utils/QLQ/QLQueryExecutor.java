package ua.javarush.task.task39.task3913.Utils.QLQ;

import ua.javarush.task.task39.task3913.DTO.QueryEntry;
import ua.javarush.task.task39.task3913.LogParser;

import java.util.HashSet;
import java.util.Set;

public class QLQueryExecutor {
    private final QLQueryReader reader;
    private final LogParser logParser;

    public QLQueryExecutor(LogParser logParser) {
        this.logParser = logParser;
        this.reader = new QLQueryReader();
    }

    public Set<Object> execute(String query) {
        QueryEntry queryEntry = reader.parseQuery(query);

        switch (queryEntry.getType()) {
            case 1:
                return handleType1(queryEntry);
            case 2:
                return handleType2(queryEntry);
            case 3:
                return handleType3(queryEntry);
            default:
                throw new IllegalArgumentException("Unsupported query type");
        }
    }

    // 5.1.1. get ip
    // 5.1.2. get user
    // 5.1.3. get date
    // 5.1.4. get event
    // 5.1.5. get status
    private Set<Object> handleType1(QueryEntry queryEntry) {
        String filter = queryEntry.getQueryFilter().name();

        switch (filter.toLowerCase()) {
            case "ip":
                return new HashSet<>(logParser.getUniqueIPs(null, null));
            case "user":
                return new HashSet<>(logParser.getAllUsers());
            case "date":
                return new HashSet<>(logParser.getAllUniqDates());
            case "status":
                return new HashSet<>(logParser.getAllUniqStatuses());
            case "event":
                return new HashSet<>(logParser.getAllEvents(null, null));
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filter);
        }
    }

    private Set<Object> handleType2(QueryEntry queryEntry) {
        return null;
    }

    private Set<Object> handleType3(QueryEntry queryEntry) {
        return null;
    }
}
