package ua.javarush.task.task39.task3913;

import java.nio.file.Paths;

public class Solution {
    private static final String LOG_FILE_PATH = "src/ua/javarush/task/task39/task3913/logs/";
    private static final String TYPE2_QUERY = " user = \"Vasya Pupkin\"";
    private static final String TYPE2_QUERY2 = "get user for ip = \"192.168.100.2\"";
    private static final String ipByDate = "get ip for date = 14.10.2021 11:38:21";

    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get(LOG_FILE_PATH));

      //  System.out.println(logParser.getUsersForIP("192.168.100.2", null, null));
        System.out.println(logParser.execute(ipByDate));

    }
}