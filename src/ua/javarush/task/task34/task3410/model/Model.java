package ua.javarush.task.task34.task3410.model;

import ua.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

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

    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public void restartLevel(int level) {
        this.currentLevel = level;
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void move(Direction direction) {
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
       Set<Wall> walls = gameObjects.getWalls();
        for (Wall wall : walls) {
            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }

        return false;
    }
}