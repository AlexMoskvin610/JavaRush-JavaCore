package ua.javarush.task.task39.task3913.Utils.QLQ;

import ua.javarush.task.task39.task3913.DTO.QueryEntry;
import ua.javarush.task.task39.task3913.DTO.enums.QueryFilter;
import ua.javarush.task.task39.task3913.DTO.enums.QueryType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QLQueryReader {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Pattern PATTERN = Pattern.compile(
            "^(.*?)(?:\\s+for\\s+(.+?))?(?:\\s+and\\s+(.*))?$"
    );

    public QueryEntry readQuery() {
        while (true) {
            System.out.println("Enter Query:");

            try {
                String line = reader.readLine();

                if (line != null && !line.isEmpty()) {
                    return parseQuery(line);
                }
            } catch (Exception e) {
                System.out.println("Invalid Query, please try again");
                System.out.println();
            }
        }
    }

    public QueryEntry parseQuery(String line) {
        Matcher matched = PATTERN.matcher(line);

        if (!matched.matches()) {
            throw new IllegalArgumentException();
        }

        return parseParts(matched.group(1), matched.group(2), matched.group(3));
    }

    private QueryEntry parseParts(String... parts) {
        QueryEntry queryEntry = new QueryEntry();

        if (parts[0] != null && !parts[0].isEmpty()) {
            parsePart1(parts[0], queryEntry);
        }
        if (parts[1] != null && !parts[1].isEmpty()) {
            parsePart2(parts[1], queryEntry);
        }
        if (parts[2] != null && !parts[2].isEmpty()) {
            parsePart3(parts[2], queryEntry);
        }

        return queryEntry;
    }

    //get field1 ||||  for field2 = "value1" ||||| and date between "after" and "before"
    private static void parsePart1(String part, QueryEntry queryEntry) {
        String[] queryParts = part.trim().split("\\s+");

        queryEntry.setType(1);
        queryEntry.setQueryType(QueryType.fromString(queryParts[0]));
        queryEntry.setQueryFilter(QueryFilter.fromString(queryParts[1]));
    }

    //field2 = "value1"
    private static void parsePart2(String part, QueryEntry queryEntry) {
        String[] query = part.trim().split("=");

        queryEntry.setType(2);
        queryEntry.setQueryFilter2(QueryFilter.fromString(query[0].trim()));
        queryEntry.setFilter2Value(cleanString(query[1]));
    }

    private static void parsePart3(String part, QueryEntry queryEntry) {
    }

    private static String cleanString(String string) {
        return string.trim().toLowerCase(Locale.ROOT).replaceAll("^[\"']+|[\"']$", "");
    }
}
