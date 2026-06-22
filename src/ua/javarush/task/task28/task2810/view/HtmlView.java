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
    // private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("[.]", "/") + "/jobPostings.html";
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
           Element templatePattern = elementOriginal.clone();

           templatePattern.removeAttr("style");
           templatePattern.removeClass("template");

           System.out.println("Original Element: " + elementOriginal);
           System.out.println("Template Pattern: " + templatePattern.html());
       }catch (Exception e){
           e.printStackTrace();
       }

        return "Some exception occurred";
    }

    //content - нове тіло файлу
    private void updateFile(String content) {
//        try (FileWriter fileWriter = new FileWriter(filePath)) {
//            fileWriter.write(content);
//            fileWriter.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
