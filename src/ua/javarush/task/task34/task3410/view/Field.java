package ua.javarush.task.task34.task3410.view;

import ua.javarush.task.task34.task3410.controller.EventListener;
import ua.javarush.task.task34.task3410.model.Direction;
import ua.javarush.task.task34.task3410.model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;
    private Set<GameObject> gameObjects;

    public Field(View view) {
        this.view = view;
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
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

    public class KeyHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    eventListener.move(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    eventListener.move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_UP:
                    eventListener.move(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    eventListener.move(Direction.DOWN);
                    break;
                case KeyEvent.VK_R:
                    eventListener.restart();
                    break;
            }
        }

    }
}
