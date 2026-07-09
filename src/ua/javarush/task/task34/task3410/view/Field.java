package ua.javarush.task.task34.task3410.view;

import ua.javarush.task.task34.task3410.controller.EventListener;
import ua.javarush.task.task34.task3410.model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;
    private Set<GameObject> gameObjects;

    public Field(View view) {
        this.view = view;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, getWidth(), getHeight());

        gameObjects = view.getGameObjects().getAll();

        for (GameObject gameObject : gameObjects) {
            gameObject.draw(graphics);
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
