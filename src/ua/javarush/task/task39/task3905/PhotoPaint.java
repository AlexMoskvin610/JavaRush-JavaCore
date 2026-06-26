package ua.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (!isPointInBound(image, x, y) || isColorNotTheSame(image, x, y, desiredColor)) {
            return false;
        }

        return fillImage(image, x, y, desiredColor);
    }

    private boolean fillImage(Color[][] image, int x, int y, Color desiredColor) {
        for (int i = y; i < image.length; i++) {
            for (int j = x; j < image[i].length; j++) {
                image[i][j] = desiredColor;
            }
        }

        return true;
    }

    private boolean isColorNotTheSame(Color[][] image, int x, int y, Color desiredColor) {
        return image[y][x] == desiredColor;
    }

    private boolean isPointInBound(Color[][] image, int x, int y) {
        int lengthY = image.length;
        int lengthX = image[0].length;

        return x >= 0 && y >= 0 && x < lengthX && y < lengthY;
    }
}
