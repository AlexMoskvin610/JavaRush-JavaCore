package ua.javarush.task.task39.task3913.Utils.QLQ;

import ua.javarush.task.task39.task3913.DAO.LogReader;
import ua.javarush.task.task39.task3913.DTO.LogEntry;
import ua.javarush.task.task39.task3913.DTO.QueryEntry;
import ua.javarush.task.task39.task3913.DTO.enums.QueryFilter;
import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;
import ua.javarush.task.task39.task3913.Utils.common.DateFormatter;

import java.nio.file.Path;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class QLQueryExecutor {
    private final QLQueryReader reader;
    private final LogReader logReader;

    public QLQueryExecutor(Path logDir) {
        this.reader = new QLQueryReader();
        this.logReader = new LogReader(logDir);
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

    private Set<Object> handleType1(QueryEntry queryEntry) {
        return executeQuery(queryEntry.getQueryFilter(), null, null, null, null);
    }

    private Set<Object> handleType2(QueryEntry queryEntry) {
        return executeQuery(
                queryEntry.getQueryFilter(),
                queryEntry.getQueryFilter2(),
                queryEntry.getFilter2Value(),
                null,
                null
        );
    }

    private Set<Object> handleType3(QueryEntry queryEntry) {
        return executeQuery(
                queryEntry.getQueryFilter(),
                queryEntry.getQueryFilter2(),
                queryEntry.getFilter2Value(),
                DateFormatter.parseDate(queryEntry.getStartDate()),
                DateFormatter.parseDate(queryEntry.getEndDate())
        );
    }

    private Set<Object> executeQuery(QueryFilter resultField, QueryFilter filterField, String filterValue,
                                     Date after, Date before) {
        Set<Object> result = new HashSet<>();

        for (LogEntry logEntry : logReader.getLogs()) {
            if (!isDateInRange(logEntry.getDate(), after, before)) {
                continue;
            }
            if (filterField != null && !matches(logEntry, filterField, filterValue)) {
                continue;
            }

            result.add(getFieldValue(logEntry, resultField));
        }

        return result;
    }

    private boolean matches(LogEntry logEntry, QueryFilter filterField, String filterValue) {
        switch (filterField.name().toLowerCase(Locale.ROOT)) {
            case "ip":
                return logEntry.getIp().equalsIgnoreCase(filterValue);
            case "user":
                return logEntry.getUser().equalsIgnoreCase(filterValue);
            case "date":
                return logEntry.getDate().equals(DateFormatter.parseDate(filterValue));
            case "event":
                return logEntry.getEvent() == Event.valueOf(filterValue.toUpperCase(Locale.ROOT));
            case "status":
                return logEntry.getStatus() == Status.valueOf(filterValue.toUpperCase(Locale.ROOT));
            case "task_number":
                return logEntry.getTaskNumber() == Integer.parseInt(filterValue);
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filterField);
        }
    }

    private Object getFieldValue(LogEntry logEntry, QueryFilter resultField) {
        switch (resultField.name().toLowerCase(Locale.ROOT)) {
            case "ip":
                return logEntry.getIp();
            case "user":
                return logEntry.getUser();
            case "date":
                return logEntry.getDate();
            case "event":
                return logEntry.getEvent();
            case "status":
                return logEntry.getStatus();
            case "task_number":
                return logEntry.getTaskNumber();
            default:
                throw new IllegalArgumentException("Unsupported filter: " + resultField);
        }
    }

    private boolean isDateInRange(Date date, Date after, Date before) {
        if (after != null && date.getTime() < after.getTime()) return false;
        if (before != null && date.getTime() > before.getTime()) return false;

        return true;
    }
}
