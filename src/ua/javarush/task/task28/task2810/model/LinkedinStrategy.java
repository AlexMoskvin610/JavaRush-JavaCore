package ua.javarush.task.task28.task2810.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class LinkedinStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (jsoup)";
    private static final int TIMEOUT = 5 * 1000;

    private List<JobPosting> jobPostings;


    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        String url = String.format(URL_FORMAT, searchString, 75);
        Document document;

        try {
            document = Jsoup.connect(url)
                    .userAgent(USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();

            saveHTML(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jobPostings == null || jobPostings.isEmpty()) {
            return Collections.emptyList();
        }

        return Collections.emptyList();
    }

    private static void saveHTML(Document document) {
        File file = new File("linkedin.html");

        try (PrintWriter writer = new PrintWriter(file, "UTF-8")) {
            writer.write(document.html());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}