package ua.javarush.task.task39.task3913;

import ua.javarush.task.task39.task3913.DAO.LogReader;
import ua.javarush.task.task39.task3913.Utils.IPQueryImpl;


import java.nio.file.Paths;

public class Solution {
    private static final String LOG_FILE_PATH = "src/ua/javarush/task/task39/task3913/logs/example.log";

    public static void main(String[] args) {
        IPQueryImpl ipQuery = new IPQueryImpl(Paths.get(LOG_FILE_PATH));

        System.out.println("Unique IPs: " + ipQuery.getNumberOfUniqueIPs(null, null));
        System.out.println("IPs for user 'Amigo': " + ipQuery.getIPsForUser("Amigo", null, null));
        System.out.println("IPs for event 'LOGIN': " + ipQuery.getIPsForEvent(Event.LOGIN, null, null));
        System.out.println("IPs for status 'OK': " + ipQuery.getIPsForStatus(Status.OK, null, null));
    }
}