package ua.javarush.task.task28.task2810;

import ua.javarush.task.task28.task2810.model.LinkedinStrategy;
import ua.javarush.task.task28.task2810.model.Model;
import ua.javarush.task.task28.task2810.model.Provider;
import ua.javarush.task.task28.task2810.view.HtmlView;
import ua.javarush.task.task28.task2810.view.View;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(new LinkedinStrategy());
        HtmlView view = new HtmlView();
        Model model = new Model(view, provider);
        Controller controller = new Controller(model);

        view.setController(controller);
        view.emulateCitySelection();

    }
}