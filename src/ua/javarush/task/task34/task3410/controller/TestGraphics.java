package ua.javarush.task.task34.task3410.controller;

import javax.swing.*;
import java.awt.*;
import ua.javarush.task.task34.task3410.model.Box;
import ua.javarush.task.task34.task3410.model.Player;

public class TestGraphics extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Создаем твой ящик. Координаты центра: x=100, y=100.
        // Убедись, что ширина (width) и высота (height) у ящика заданы (например, 20 или 40)
        Box box = new Box(100, 100);
        box.draw(g); // Вызываем твой метод отрисовки!

        Player player = new Player(50, 50);
        player.draw(g); // Вызываем твой метод отрисовки!
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Тест графики Сокобана");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200); // размер окошка
        frame.add(new TestGraphics());
        frame.setLocationRelativeTo(null); // по центру экрана
        frame.setVisible(true);
    }
}