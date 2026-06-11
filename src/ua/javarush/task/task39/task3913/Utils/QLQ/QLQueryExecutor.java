package ua.javarush.task.task39.task3913.Utils.QLQ;

import ua.javarush.task.task39.task3913.DTO.QueryEntry;
import ua.javarush.task.task39.task3913.LogParser;

import java.util.Collections;
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

        return switch (queryEntry.getType()) {
            case 1 -> handleType1(queryEntry);
            case 2 -> handleType2(queryEntry);
            case 3 -> handleType3(queryEntry);
            default -> throw new IllegalArgumentException("Unsupported query type");
        };
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
                return Collections.singleton(logParser.getUniqueIPs(null, null));
            case "user":
                return Collections.singleton(logParser.getAllUsers());
            case "date", "status":
                return null;
            case "event":
                return Collections.singleton(logParser.getAllEvents(null, null));
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
