package ua.javarush.task.task28.task2810;

import ua.javarush.task.task28.task2810.model.Provider;
import ua.javarush.task.task28.task2810.vo.JobPosting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private final Provider[] providers;

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }

        this.providers = providers;
    }

    public void scan() {
        List<JobPosting> jobPostings = new ArrayList<>();

        for (Provider provider : providers) {
            jobPostings.addAll(provider.getJavaJobPostings(""));
        }

        System.out.println(jobPostings.size());
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}