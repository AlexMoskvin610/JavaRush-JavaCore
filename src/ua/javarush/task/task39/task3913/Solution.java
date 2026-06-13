package ua.javarush.task.task39.task3913;

import java.nio.file.Paths;

public class Solution {
    private static final String LOG_FILE_PATH = "src/ua/javarush/task/task39/task3913/logs/";
    private static final String TYPE2_QUERY = " user = \"Vasya Pupkin\"";
    private static final String TYPE3_QUERY = "get ip " +
            "for user = \"Eduard Petrovich Morozko\"" +
            " and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"";
    private static final String getIPforEvent = "get ip " +
            "for event = \"DONE_TASK\" " +
            "and date between\"10.12.2020 0:00:00\" and \"03.01.2024 23:59:59\"";
    private static final String getIPforStatus = "get ip " +
            "for status = \"OK\" " +
            "and date between\"10.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"";
    private static final String dateByIP = "get date for ip = \"192.168.100.2\"";
    private static final String ipByDate = "get ip for date = 14.10.2021 11:38:21";
    private static final String ipByEvent = "get ip for event = \"SOLVE_TASK\"";
    private static final String userByStatus = "get user for status = \"OK\"";
    private static final String eventByDate = "get event for date = \"14.10.2021 11:38:21\"";
    private static final String statusByEvent = "get status for event = \"DONE_TASK\"";

    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get(LOG_FILE_PATH));

        // System.out.println(logParser.execute(TYPE3_QUERY));
       // System.out.println(logParser.execute(getIPforStatus));
        System.out.println(logParser.execute(getIPforEvent));
    }
}