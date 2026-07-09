package ua.javarush.task.task34.task3410.controller;

import ua.javarush.task.task34.task3410.model.Direction;
import ua.javarush.task.task34.task3410.model.Model;
import ua.javarush.task.task34.task3410.view.View;

import java.awt.event.ActionListener;

public class Controller implements EventListener {
    private Model model;
    private View view;

    public Controller() {
        this.model = new Model();
        this.view = new View(this);
        this.view.init();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void restart() {

    }

    @Override
    public void startNextLevel() {

    }

    @Override
    public void levelCompleted(int level) {

    }
}