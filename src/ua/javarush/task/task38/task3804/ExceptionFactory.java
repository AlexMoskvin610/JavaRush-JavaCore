package ua.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum enumValue) {
        if (enumValue == null) {
            return new IllegalArgumentException();
        }

        String message = enumValue.toString().replace("_", " ").trim().toLowerCase();
        String formattedMessage = message.substring(0, 1).toUpperCase() + message.substring(1);

        if (enumValue instanceof ApplicationExceptionMessage) {
            return new Exception(formattedMessage);
        } else if (enumValue instanceof UserExceptionMessage) {
            return new Error(formattedMessage);
        }else if (enumValue instanceof DatabaseExceptionMessage){
            return new RuntimeException(formattedMessage);
        }

        return new IllegalArgumentException();
    }
}
