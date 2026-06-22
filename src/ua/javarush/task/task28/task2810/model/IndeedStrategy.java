package ua.javarush.task.task28.task2810.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IndeedStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.indeed.com/jobs?q=java+%s&start=%d";

    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        return null;
    }

    protected Document getDocument(String searchString, int start) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, start))
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")
                .get();
    }

    protected Document readDocument(String searchString, int start) throws IOException {
        if (start == 0) {
            File input = new File("src/ua/javarush/task/task28/task2810/indeed.html");

            return Jsoup.parse(input, "UTF-8", "https://www.indeed.com/");
        }

        return Jsoup.parse("<html><body></body></html>");
    }
}
