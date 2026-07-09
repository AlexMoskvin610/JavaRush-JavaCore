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

        int leftX = this.getX() - getWidth() / 2;
        int upperY = this.getY() - getHeight() / 2;

        // graphics.fillRect(leftX, upperY, getWidth(), getHeight());

       // graphics.setColor(Color.BLACK);
        graphics.drawRect(leftX, upperY, getWidth(), getHeight());
        graphics.drawLine(leftX, upperY, leftX + getWidth(), upperY + getHeight());
        graphics.drawLine(leftX, upperY + getHeight(), leftX + getWidth(), upperY);
    }
}
