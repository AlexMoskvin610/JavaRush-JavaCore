package ua.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
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
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        int loopLevel = level % 60;

        if (loopLevel == 0) {
            loopLevel = 60;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
            String line;

            // 1. Ищем начало нужного уровня
            while ((line = reader.readLine()) != null) {
                if (line.contains("Maze: " + loopLevel)) {
                    break;
                }
            }

            // 2. Пропускаем метаданные до первой пустой строки
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
            }

            // 3. Читаем саму карту
            int y = 0; // Индекс строки (координата Y на сетке)
            while ((line = reader.readLine()) != null) {
                // Если наткнулись на пустую строку — карта закончилась
                if (line.isEmpty()) {
                    break;
                }

                // Проходим по каждому символу в строке
                for (int x = 0; x < line.length(); x++) {
                    char symbol = line.charAt(x);

                    // 4. Переводим индексы сетки в пиксельные координаты ЦЕНТРА
                    int pixelX = x * Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE / 2;
                    int pixelY = y * Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE / 2;

                    // 5. Создаем нужные объекты
                    switch (symbol) {
                        case 'X':
                            walls.add(new Wall(pixelX, pixelY));
                            break;
                        case '*':
                            boxes.add(new Box(pixelX, pixelY));
                            break;
                        case '.':
                            homes.add(new Home(pixelX, pixelY));
                            break;
                        case '@':
                            player = new Player(pixelX, pixelY);
                            break;
                        case '&': // Ящик уже стоит на месте
                            boxes.add(new Box(pixelX, pixelY));
                            homes.add(new Home(pixelX, pixelY));
                            break;
                    }
                }
                y++; // Переходим на следующую строку карты
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameObjects(walls, boxes, homes, player);
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