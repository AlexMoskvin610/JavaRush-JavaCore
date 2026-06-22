package ua.javarush.task.task28.task2810.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndeedStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.indeed.com/jobs?q=java+%s&start=%d";
    private static final String URL_TEMP = "https://javarush.com/testdata/big28indeed.html";

    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        List<JobPosting> allVacancies = new ArrayList<>();

        int start = 0;
        try {
            do {
                // Document doc = getDocument(searchString, start);
                Document doc = readDocument(searchString, start);

                Elements vacanciesHtmlList = doc.select(".jobsearch-SerpJobCard");

                if (vacanciesHtmlList.isEmpty()) {
                    break;
                }

                for (Element element : vacanciesHtmlList) {
                    Elements titleAndUrl = element.getElementsByClass("turnstileLink");
                    Elements locations = element.getElementsByClass("location");
                    Elements companyName = element.getElementsByClass("company");

                    JobPosting vacancy = new JobPosting();

                    vacancy.setWebsiteName("indeed.com");
                    vacancy.setTitle(titleAndUrl.get(0).text());
                    vacancy.setUrl(titleAndUrl.get(0).attr("abs:href"));
                    vacancy.setCity(locations.get(0).text());
                    vacancy.setCompanyName(companyName.get(0).text());

                    allVacancies.add(vacancy);
                }

                start += 25;

            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return allVacancies;
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
