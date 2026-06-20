package ua.javarush.task.task28.task2810.model;

import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.util.List;

public interface Strategy {
    public List<JobPosting> getJobPostings(String searchString);
}
