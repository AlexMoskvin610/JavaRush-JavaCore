package ua.javarush.task.task28.task2810.model;

public class LinkedinStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";
    private String URL = getFormattedURL();

    public String getURL_FORMAT() {
        return URL_FORMAT;
    }

    public String getFormattedURL() {
        return String.format(URL_FORMAT, "San+Francisco", 75);
    }
}
