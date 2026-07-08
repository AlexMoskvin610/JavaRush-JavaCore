package ua.javarush.task.task34.task3410.controller;

import ua.javarush.task.task34.task3410.model.Model;
import ua.javarush.task.task34.task3410.view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller() {
        this.model = new Model();
        this.view = new View(this);
    }

    public static void main(String[] args) {
    }
}
