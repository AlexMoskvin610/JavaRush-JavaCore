package ua.javarush.task.task28.task2810.view;

import ua.javarush.task.task28.task2810.Controller;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.util.List;

public interface View {
    void update(List<JobPosting> jobPostings);
    void setController(Controller controller);
}
