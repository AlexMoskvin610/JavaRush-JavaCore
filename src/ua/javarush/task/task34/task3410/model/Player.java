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

        int leftX = this.getX() - getWidth() / 2;
        int upperY = this.getY() - getHeight() / 2;

      //  graphics.fillOval(leftX, upperY, getWidth(), getHeight());

      //  graphics.setColor(Color.BLACK);
        graphics.drawOval(leftX, upperY, getWidth(), getHeight());
    }
}
