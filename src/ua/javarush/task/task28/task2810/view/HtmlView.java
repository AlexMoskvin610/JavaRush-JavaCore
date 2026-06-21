package ua.javarush.task.task28.task2810.view;

import ua.javarush.task.task28.task2810.Controller;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.util.List;

public class HtmlView implements View {
    private Controller controller;

    @Override
    public void update(List<JobPosting> vacancies) {
        System.out.println(vacancies.size());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void emulateCitySelection() {
        controller.onCitySelected("Odesa");
    }
}
