package ua.javarush.task.task28.task2810.model;

import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.util.Collections;
import java.util.List;

public class LinkedinStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";

    private String URL = getFormattedURL();
    private List<JobPosting> jobPostings;

    public String getURL_FORMAT() {
        return URL_FORMAT;
    }

    public String getFormattedURL() {
        return String.format(URL_FORMAT, "San+Francisco", 75);
    }

    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        // String url = String.format(URL_FORMAT, searchString, pageNumber * 25);
        if (jobPostings==null || jobPostings.isEmpty()) {
            return Collections.emptyList();
        }

        return Collections.emptyList();
    }
}