package ua.javarush.task.task28.task2810.view;

import ua.javarush.task.task28.task2810.Controller;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.util.List;

public class HtmlView implements View {
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("[.]", "/") + "/jobPostings.html";

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
        return null;
    }

    private void updateFile(String content) {
    }
}
