package ua.javarush.task.task39.task3913;

import ua.javarush.task.task39.task3913.Utils.LogReader;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    private static final String LOG_FILE_PATH = "src/ua/javarush/task/task39/task3913/logs/example.log";

    public static void main(String[] args) {
        LogReader logReader = new LogReader(Paths.get(LOG_FILE_PATH));

        logReader.getLogList().forEach(System.out::println);
    }
}