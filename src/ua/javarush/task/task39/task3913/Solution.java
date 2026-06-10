package ua.javarush.task.task39.task3913;

import java.nio.file.Paths;

public class Solution {
    private static final String LOG_FILE_PATH = "src/ua/javarush/task/task39/task3913/logs/";
    private static final String GET_IP = "get ip";
    private static final String GET_STATUS = "get status";

    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get(LOG_FILE_PATH));

        // logParser.execute(GET_IP).forEach(System.out::println);
        logParser.execute(GET_STATUS).forEach(System.out::println);
    }
}