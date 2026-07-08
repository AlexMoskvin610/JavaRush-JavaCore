package ua.javarush.task.task34.task3410.model;

import java.awt.*;

import static ua.javarush.task.task34.task3410.model.Model.FIELD_CELL_SIZE;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int collisionX = gameObject.getX();
        int collisionY = gameObject.getY();

        switch (direction) {
            case UP: {
                return this.y - FIELD_CELL_SIZE == collisionY && collisionX == this.x;
            }
            case DOWN: {
                return this.y + FIELD_CELL_SIZE == collisionY && collisionX == this.x;
            }
            case LEFT: {
                return this.x - FIELD_CELL_SIZE == collisionX && collisionY == this.y;
            }
            case RIGHT: {
                return this.x + FIELD_CELL_SIZE == collisionX && collisionY == this.y;
            }
            default: {
                return false;
            }
        }
    }
}
