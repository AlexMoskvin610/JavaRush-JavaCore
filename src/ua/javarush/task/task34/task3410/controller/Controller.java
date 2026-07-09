package ua.javarush.task.task34.task3410.controller;

import ua.javarush.task.task34.task3410.model.Direction;
import ua.javarush.task.task34.task3410.model.GameObjects;
import ua.javarush.task.task34.task3410.model.LevelLoader;
import ua.javarush.task.task34.task3410.model.Model;
import ua.javarush.task.task34.task3410.view.Field;
import ua.javarush.task.task34.task3410.view.View;

import java.awt.event.ActionListener;

public class Controller implements EventListener {
    private Model model;
    private View view;

    public Controller() {
        this.model = new Model();
        this.view = new View(this);

        this.model.setEventListener(this);
        this.view.setEventListener(this);

        this.view.init();
        this.model.restart();


    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

    public GameObjects getGameObjects() {
        return model.getGameObjects();
    }
}