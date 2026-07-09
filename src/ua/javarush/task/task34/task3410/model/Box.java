package ua.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);

        int upperLeftX = this.getX() - getWidth() / 2;
        int upperLeftY = this.getY() - getHeight() / 2;

         graphics.fillRect(upperLeftX, upperLeftY, getWidth(), getHeight());

        graphics.setColor(Color.WHITE);
        graphics.drawRect(upperLeftX, upperLeftY, getWidth(), getHeight());
        graphics.drawLine(upperLeftX, upperLeftY, upperLeftX + getWidth(), upperLeftY + getHeight());
        graphics.drawLine(upperLeftX, upperLeftY + getHeight(), upperLeftX + getWidth(), upperLeftY);
    }
}
