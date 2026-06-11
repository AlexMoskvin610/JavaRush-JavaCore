package ua.javarush.task.task39.task3913;

import java.nio.file.Paths;

public class Solution {
    private static final String LOG_FILE_PATH = "src/ua/javarush/task/task39/task3913/logs/";
    private static final String TYPE2_QUERY = "get ip for user = \"Vasya\"";

    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get(LOG_FILE_PATH));

        logParser.execute(TYPE2_QUERY);

    }
}