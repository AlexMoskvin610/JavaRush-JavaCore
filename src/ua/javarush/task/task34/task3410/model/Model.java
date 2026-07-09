package ua.javarush.task.task34.task3410.model;

import ua.javarush.task.task34.task3410.controller.EventListener;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Set;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;

    private LevelLoader levelLoader;

    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;

    public Model() {
        try {
            this.levelLoader = new LevelLoader(Paths.get(getClass().getResource("../res/levels.txt").toURI()));
        } catch (URISyntaxException e) {
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
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
        gameObjects = levelLoader.getLevel(level);
    }

    public void move(Direction direction) {
        if (checkWallCollision(gameObjects.getPlayer(), direction)) {
            return;
        } else if (checkBoxCollisionAndMoveIfAvailable(direction)) {
            return;
        } else {
            switch (direction) {
                case UP:
                    gameObjects.getPlayer().move(0, -FIELD_CELL_SIZE);
                    break;
                case DOWN:
                    gameObjects.getPlayer().move(0, FIELD_CELL_SIZE);
                    break;
                case LEFT:
                    gameObjects.getPlayer().move(-FIELD_CELL_SIZE, 0);
                    break;
                case RIGHT:
                    gameObjects.getPlayer().move(FIELD_CELL_SIZE, 0);
                    break;
            }

            checkCompletion();
        }
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

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        for (Box box : gameObjects.getBoxes()) {

            if (gameObjects.getPlayer().isCollision(box, direction)) {

                if (checkWallCollision(box, direction)) {
                    return true;
                }

                for (Box otherBox : gameObjects.getBoxes()) {
                    if (box != otherBox && box.isCollision(otherBox, direction)) {
                        return true;
                    }
                }

                switch (direction) {
                    case UP:
                        box.move(0, -FIELD_CELL_SIZE);
                        break;
                    case DOWN:
                        box.move(0, FIELD_CELL_SIZE);
                        break;
                    case LEFT:
                        box.move(-FIELD_CELL_SIZE, 0);
                        break;
                    case RIGHT:
                        box.move(FIELD_CELL_SIZE, 0);
                        break;
                }

                return false;
            }
        }

        return false;
    }

    public void checkCompletion() {
        Set<Home> homes = gameObjects.getHomes();
        int controlCount = 0;

        for (Home home : homes) {
            for (Box box : gameObjects.getBoxes()) {
                if (home.getX() == box.getX() && home.getY() == box.getY()) {
                    controlCount++;
                    break;
                }
            }
        }

        if (controlCount == homes.size()) {
            eventListener.levelCompleted(currentLevel);
        }
    }
}