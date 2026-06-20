package ua.javarush.task.task28.task2810.model;

public class LinkedinStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";

    public String getURL_FORMAT() {
        return URL_FORMAT;
    }
}