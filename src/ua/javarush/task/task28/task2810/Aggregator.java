package ua.javarush.task.task28.task2810;

import ua.javarush.task.task28.task2810.model.LinkedinStrategy;
import ua.javarush.task.task28.task2810.model.Provider;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider1 = new Provider(null);
        Controller controller1 = new Controller(provider1);

        provider1.setStrategy(new LinkedinStrategy());
        controller1.scan();
    }
}