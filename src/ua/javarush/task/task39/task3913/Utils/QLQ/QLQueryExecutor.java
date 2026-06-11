package ua.javarush.task.task39.task3913.Utils.QLQ;

import ua.javarush.task.task39.task3913.DTO.QueryEntry;
import ua.javarush.task.task39.task3913.LogParser;
import ua.javarush.task.task39.task3913.Utils.QLQ.executorHelper.DataExecutorHelper;
import ua.javarush.task.task39.task3913.Utils.QLQ.executorHelper.IPExecutorHelper;
import ua.javarush.task.task39.task3913.Utils.QLQ.executorHelper.UserExecutorHelper;

import java.util.HashSet;
import java.util.Set;

public class QLQueryExecutor {
    private final QLQueryReader reader;
    private final LogParser logParser;
    private final UserExecutorHelper userHelper;
    private final IPExecutorHelper ipHelper;
    private final DataExecutorHelper dataHelper;

    public QLQueryExecutor(LogParser logParser) {
        this.logParser = logParser;
        this.reader = new QLQueryReader();
        this.userHelper = new UserExecutorHelper(logParser);
        this.ipHelper = new IPExecutorHelper(logParser);
        this.dataHelper = new DataExecutorHelper(logParser);
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
    //1) get ip for user = "Vasya"
    // 2) get user for event = "DONE_TASK"
    // 3) get event for date = "03.01.2014 03:45:23"
    private Set<Object> handleType1(QueryEntry queryEntry) {
        String filter = queryEntry.getQueryFilter().name();

        switch (filter.toLowerCase()) {
            case "ip":
                return new HashSet<>(logParser.getUniqueIPs(null, null));
            case "user":
                return new HashSet<>(logParser.getAllUsers());
            case "date":
                return new HashSet<>(logParser.getAllUniqueDates());
            case "status":
                return new HashSet<>(logParser.getAllUniqueStatuses());
            case "event":
                return new HashSet<>(logParser.getAllEvents(null, null));
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filter);
        }
    }

    //GET IP FOR USER vasya
    private Set<Object> handleType2(QueryEntry queryEntry) {

        String filter = queryEntry.getQueryFilter().name();
        String filter2 = queryEntry.getQueryFilter2().name();
        String filter2Value = queryEntry.getFilter2Value();

        switch (filter.toLowerCase()) {
            case "user" :
                return userHelper.executeQuery(filter2, filter2Value);
            case "ip" :
                return ipHelper.executeQuery(filter2, filter2Value);
            case "date" :
                return dataHelper.executeQuery(filter2, filter2Value);
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filter);
        }
    }

    private Set<Object> handleType3(QueryEntry queryEntry) {
        return null;
    }
}
