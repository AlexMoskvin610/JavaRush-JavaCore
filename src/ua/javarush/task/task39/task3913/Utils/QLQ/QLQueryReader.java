package ua.javarush.task.task39.task3913.Utils.QLQ;

import ua.javarush.task.task39.task3913.DTO.QueryEntry;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QLQueryReader {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static QueryEntry readQuery() {
        while (true) {
            System.out.println("Enter Query:");

            try {
                String line = reader.readLine();
                if (line.equals("")) {

                    return parseQuery(line);
                }
            } catch (Exception e) {
                System.out.println("Invalid Query, please try again");
                System.out.println();
            }
        }
    }

    private static QueryEntry parseQuery(String line) {
        return null;
    }
}
