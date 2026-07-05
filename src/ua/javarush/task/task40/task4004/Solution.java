package ua.javarush.task.task40.task4004;

import java.util.ArrayList;
import java.util.List;

/* 
Приналежність точки до багатокутника
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();

        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(10, 5), polygon));
        System.out.println(isPointInPolygon(new Point(2, 8), polygon));
        System.out.println(isPointInPolygon(new Point(11, 10), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        int maxX = polygon.stream().mapToInt(p -> p.x).max().orElse(0);
        int minX = polygon.stream().mapToInt(p -> p.x).min().orElse(0);

        int maxY = polygon.stream().mapToInt(p -> p.y).max().orElse(0);
        int minY = polygon.stream().mapToInt(p -> p.y).min().orElse(0);

        return point.x >= minX && point.x <= maxX  && point.y >= minY && point.y <= maxY;
    }
}

