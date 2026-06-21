package ua.javarush.task.task28.task2810.view;

import ua.javarush.task.task28.task2810.Controller;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.util.List;

public class HtmlView implements View {
    private Controller controller;

    @Override
    public void update(List<JobPosting> jobPostings) {
        int count = jobPostings.size();

        if (count == 0) {
            return;
        }

        String city = jobPostings.get(0).getCity();

        System.out.println(count);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void emulateCitySelection() {
        controller.onCitySelected("Odesa");
    }
}
