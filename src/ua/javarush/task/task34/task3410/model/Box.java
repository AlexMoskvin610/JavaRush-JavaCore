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

        int upperleftX = this.getX() - getWidth() / 2;
        int upperLeftY = this.getY() - getHeight() / 2;

        // graphics.fillRect(upperleftX, upperLeftY, getWidth(), getHeight());

       // graphics.setColor(Color.BLACK);
        graphics.drawRect(upperleftX, upperLeftY, getWidth(), getHeight());
        graphics.drawLine(upperleftX, upperLeftY, upperleftX + getWidth(), upperLeftY + getHeight());
        graphics.drawLine(upperleftX, upperLeftY + getHeight(), upperleftX + getWidth(), upperLeftY);
    }
}
