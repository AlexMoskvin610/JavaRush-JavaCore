package ua.javarush.task.task34.task3410.model;

import java.awt.*;

public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    public void draw(java.awt.Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);

        int upperLeftX = this.getX() - getWidth() / 2;
        int upperLeftY = this.getY() - getHeight() / 2;

        graphics.fillRect(upperLeftX, upperLeftY, getWidth(), getHeight());
    }
}
