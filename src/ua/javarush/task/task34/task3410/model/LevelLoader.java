package ua.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LevelLoader {
    private final Path file;
    private final Random random = new Random();
    private int[][] field = new int[500 / Model.FIELD_CELL_SIZE][500 / Model.FIELD_CELL_SIZE];

    public LevelLoader(Path file) {
        this.file = file;
    }

    public GameObjects getLevel(int level) {
        Player player = new Player(getRandomPoint()[0], getRandomPoint()[1]);

        Set<Home> home = new HashSet<>();
        home.add(new Home(getRandomPoint()[0], getRandomPoint()[1]));

        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(getRandomPoint()[0], getRandomPoint()[1]));

        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(getRandomPoint()[0], getRandomPoint()[1]));
        walls.add(new Wall(getRandomPoint()[0], getRandomPoint()[1]));
        walls.add(new Wall(getRandomPoint()[0], getRandomPoint()[1]));
        walls.add(new Wall(getRandomPoint()[0], getRandomPoint()[1]));

        return new GameObjects(walls, boxes, home, player);
    }

    private int[] getRandomPoint() {
        int gridX = this.random.nextInt(500 / Model.FIELD_CELL_SIZE);
        int gridY = this.random.nextInt(500 / Model.FIELD_CELL_SIZE);

        if (field[gridY][gridX] == 0) {
            field[gridY][gridX] = 1;

            int pixelX = gridX * Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE / 2;
            int pixelY = gridY * Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE / 2;

            return new int[]{pixelX, pixelY};
        } else {
            return getRandomPoint();
        }
    }
}
