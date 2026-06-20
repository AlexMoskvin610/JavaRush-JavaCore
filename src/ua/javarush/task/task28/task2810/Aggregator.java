package ua.javarush.task.task28.task2810;

import ua.javarush.task.task28.task2810.model.LinkedinStrategy;
import ua.javarush.task.task28.task2810.model.Provider;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider1 = new Provider(new LinkedinStrategy());
        Controller controller1 = new Controller(provider1);

        controller1.scan();
    }
}