package ua.javarush.task.task28.task2810.model; // Проверь свой точный пакет

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=java+%s&start=%d";

    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        List<JobPosting> allVacancies = new ArrayList<>();

        int start = 0;
        try {
            do {
                Document doc = getDocument(searchString, start);

                try {
                    saveFile(doc);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Elements vacanciesHtmlList = doc.select("div.base-search-card, li.base-search-card");

                if (vacanciesHtmlList.isEmpty()) {
                    break;
                }

                for (Element element : vacanciesHtmlList) {
                    Elements title = element.getElementsByClass("base-search-card__title");
                    Elements url = element.getElementsByClass("base-card__full-link");
                    Elements locations = element.getElementsByClass("job-search-card__location");
                    Elements companyName = element.getElementsByClass("base-search-card__subtitle");

                    JobPosting vacancy = new JobPosting();

                    vacancy.setWebsiteName("linkedin.com");
                    vacancy.setTitle(title.get(0).text());
                    vacancy.setUrl(url.get(0).attr("abs:href"));
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

    private void saveFile(Document document) throws IOException {
        File file = new File("linkedin.html");

        try (PrintWriter writer = new PrintWriter(file, "UTF-8")) {
            writer.write(document.html());
        }
    }
}
