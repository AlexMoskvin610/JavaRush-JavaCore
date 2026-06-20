package ua.javarush.task.task28.task2810.model;

import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class Provider {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<JobPosting> getJavaJobPostings(String searchString) {
        return new ArrayList<>();
    }
}
