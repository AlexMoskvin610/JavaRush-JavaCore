package ua.javarush.task.task34.task3410.model;

import ua.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;

    private final LevelLoader levelLoader = new LevelLoader(Paths.get("res/levels.txt"));

    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void setGameObjects(GameObjects gameObjects) {
        this.gameObjects = gameObjects;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public void restartLevel(int level) {
        this.currentLevel = level;
        this.gameObjects = levelLoader.getLevel(level);
    }
}