package ua.javarush.task.task28.task2810;

import ua.javarush.task.task28.task2810.model.IndeedStrategy;
import ua.javarush.task.task28.task2810.model.LinkedinStrategy;
import ua.javarush.task.task28.task2810.model.Model;
import ua.javarush.task.task28.task2810.model.Provider;
import ua.javarush.task.task28.task2810.view.HtmlView;
import ua.javarush.task.task28.task2810.view.View;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(new LinkedinStrategy());
        Provider provider1 = new Provider(new IndeedStrategy());

        HtmlView view = new HtmlView();
        Model model = new Model(view, provider1);
        Controller controller = new Controller(model);

        view.setController(controller);
        view.emulateCitySelection();

    }
}