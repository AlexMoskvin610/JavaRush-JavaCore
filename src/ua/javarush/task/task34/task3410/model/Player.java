package ua.javarush.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.CYAN);

        int upperLeftX = this.getX() - getWidth() / 2;
        int upperLeftY = this.getY() - getHeight() / 2;

        graphics.fillOval(upperLeftX, upperLeftY, getWidth(), getHeight());

        graphics.setColor(Color.WHITE);
        graphics.drawOval(upperLeftX, upperLeftY, getWidth(), getHeight());
    }
}
