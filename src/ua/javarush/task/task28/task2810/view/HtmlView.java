package ua.javarush.task.task28.task2810.view;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.javarush.task.task28.task2810.Controller;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    //private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("[.]", "/") + "/jobPostings.html";
    private final String filePath = "src/ua/javarush/task/task28/task2810/view/jobPostingsTest.html";

    private Controller controller;

    @Override
    public void update(List<JobPosting> vacancies) {
        try {
            String newContent = getUpdatedFileContents(vacancies);
            
            updateFile(newContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void emulateCitySelection() {
        controller.onCitySelected("Odesa");
    }

    private String getUpdatedFileContents(List<JobPosting> vacancies) {
       try{
           Document document = getDocument();
           Elements elements = document.getElementsByClass("template");

           if (elements.isEmpty()) {
               throw new RuntimeException("Template elementOriginal not found in HTML file");
           }

           Element elementOriginal = elements.get(0);
           Element templatePattern = cleanElements(elementOriginal);

           removeOldVacancies(document);

           //<td class="title"><a href="url"></a></td>
           //<td class="city"></td>
           //<td class="companyName"></td>

           for (JobPosting vacancy : vacancies) {
               templatePattern = cleanElements(elementOriginal);

               // Назва вакансії (текст всередині тегу <a>, який лежить в <td class="title">)
               Element titleLink = templatePattern.getElementsByClass("title").select("a").first();
               if (titleLink != null) {
                   titleLink.text(vacancy.getTitle());          // Встановлюємо назву вакансії
                   titleLink.attr("href", vacancy.getUrl());    // Встановлюємо посилання на вакансію
               }

               // Місто (текст всередині <td class="city">)
               Element cityElement = templatePattern.getElementsByClass("city").first();
               if (cityElement != null) {
                   cityElement.text(vacancy.getCity());
               }

               // Назва компанії (текст всередині <td class="companyName">)
               Element companyElement = templatePattern.getElementsByClass("companyName").first();
               if (companyElement != null) {
                   companyElement.text(vacancy.getCompanyName());
               }

               elementOriginal.before(templatePattern);
           }

           return document.html();

       }catch (Exception e){
           e.printStackTrace();

           return "Some exception occurred";
       }

    }

    private Element cleanElements(Element elementOriginal) {
        Element templatePattern = elementOriginal.clone();

        templatePattern.removeAttr("style");
        templatePattern.removeClass("template");

        return templatePattern;
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private void removeOldVacancies(Document document) {
        document.select("tr.vacancy:not(.template)").remove();
    }

    //content - нове тіло файлу
    private void updateFile(String content) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {

            fileWriter.write(content);
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}