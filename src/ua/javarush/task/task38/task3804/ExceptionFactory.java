package ua.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum enumValue) {
        if (enumValue instanceof ApplicationExceptionMessage) {
            return new Exception(enumValue.toString().replaceAll("_", " "));
        } else if (enumValue instanceof UserExceptionMessage) {
            return new RuntimeException(enumValue.toString().replaceAll("_", " "));
        }
        return new IllegalArgumentException();
    }
}
