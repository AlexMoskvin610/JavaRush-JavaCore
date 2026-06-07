package ua.javarush.task.task39.task3913;

import java.nio.file.Paths;

public class Solution {
    private static final String LOG_FILE_PATH = "src/ua/javarush/task/task39/task3913/logs/";

    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get(LOG_FILE_PATH));

        System.out.println("Unique IPs: " + logParser.getNumberOfUniqueIPs(null, null));
        System.out.println("IPs for user 'Amigo': " + logParser.getIPsForUser("Amigo", null, null));
        System.out.println("IPs for event 'LOGIN': " + logParser.getIPsForEvent(Event.LOGIN, null, null));
        System.out.println("IPs for status 'OK': " + logParser.getIPsForStatus(Status.OK, null, null));
    }
}