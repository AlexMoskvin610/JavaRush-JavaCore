package ua.javarush.task.task28.task2810;

import ua.javarush.task.task28.task2810.model.Provider;

import java.util.Arrays;

public class Controller {
    private final Provider[] providers;

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }

        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}