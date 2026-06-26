package ua.javarush.task.task39.task3905;

import java.util.Random;

/* 
Залий мене повністю
*/

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[10][10];
        Random random = new Random();
        Color[] allColors = Color.values();

        // 2. Заполнение массива случайными цветами
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[y].length; x++) {
                image[y][x] = allColors[random.nextInt(allColors.length)];
            }
        }

        // 3. Вывод для проверки (удобно для отладки)
        printImage(image);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //4.  Модификация массива

        PhotoPaint paint =  new PhotoPaint();

        System.out.println(paint.paintFill(image, 2,1, Color.RED));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //5. Вівод обновленного массива для проверки

        printImage(image);
    }

    private static void printImage(Color[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.printf("%-8s ", image[i][j]);
            }
            System.out.println();
        }
    }
}
