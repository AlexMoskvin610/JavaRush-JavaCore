package ua.javarush.task.task39.task3913;

import java.nio.file.Paths;

public class Solution {
    private static final String LOG_FILE_PATH = "src/ua/javarush/task/task39/task3913/logs/";
    private static final String TYPE2_QUERY = "get ip for user = \"Vasya Pupkin\"";
    private static final String TYPE2_QUERY2 = "get user for ip = \"192.168.100.2\"";

    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get(LOG_FILE_PATH));

        System.out.println(logParser.getUsersForIP("192.168.100.2", null, null));
        System.out.println(logParser.execute(TYPE2_QUERY));

    }
}