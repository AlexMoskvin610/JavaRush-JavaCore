package ua.javarush.task.task39.task3913;

import ua.javarush.task.task39.task3913.Utils.QLQ.QLQueryReader;

public class Solution {
    private static final String LOG_FILE_PATH = "src/ua/javarush/task/task39/task3913/logs/";

    public static void main(String[] args) {
        // LogParser logParser = new LogParser(Paths.get(LOG_FILE_PATH));

        QLQueryReader reader = new QLQueryReader();

        System.out.println(reader.readQuery());

    }
}